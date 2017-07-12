package com.connect.rh.presenter.common.login;

import com.connect.rh.R;
import com.connect.rh.data.entities.entities.UserEntity;
import com.connect.rh.data.entities.mapper.LogInMapper;
import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.data.repository.NetworkRepository;
import com.connect.rh.domain.executor.impl.MainThreadImpl;
import com.connect.rh.domain.executor.impl.ThreadExecutor;
import com.connect.rh.domain.interactor.ResponseSubscriber;
import com.connect.rh.domain.interactor.common.LoginInteractor;
import com.connect.rh.presenter.abstractions.Presenter;
import com.connect.rh.utils.AuthenticationHandler;
import com.connect.rh.utils.EncryptionHelper;
import com.connect.rh.utils.JsonHelper;

/**
 * Created by Ali on 2/26/2017.
 */

public class LogInPresenter extends Presenter {
    private LogInView mView = null;
    private String mEncryptionPassword = null;
    private EncryptionHelper encryptionHelper = null;
    private PreferenceService preferenceService = null;
 //   private DbService dbService = null;

    public LogInPresenter(LogInView view) {
        super(view);
        this.mView = view;
        interactor = new LoginInteractor(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), new LogInPresenter.LogInDataSubscriber(authenticationHandler), new NetworkRepository(mView.getViewContext(), new LogInMapper()));
        encryptionHelper = new EncryptionHelper();
        preferenceService = PreferenceService.getInstance(mView.getViewContext());
//        dbService = DbService.getInstance();

    }

    public void performLogin() {
        encryptCredentials();
        mView.showProgress(mView.getViewContext().getResources().getString(R.string.sign_in));
        ((LoginInteractor) interactor).performLogIn(JsonHelper.getLoginBody(mView.getUserName(),mView.getPassword()));
    }

    private void encryptCredentials() {
        try {
            mEncryptionPassword = encryptionHelper.encrypt(mView.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    public boolean userNameExists()
    {
        if(preferenceService.getUserId().isEmpty())
        {
            return false;
        }
        return true;
    }

    public String getUserName()
    {
        return preferenceService.getUserName();
    }

    private class LogInDataSubscriber extends ResponseSubscriber<UserEntity> {

        LogInDataSubscriber(AuthenticationHandler authenticationHandler) {
            super(authenticationHandler);
        }

        @Override
        protected void onSuccess(UserEntity entity) {
             mView.hideProgress();
            handleLogInDataSuccess(entity);
        }

        @Override
        protected void onFailure(String error) {
             mView.hideProgress();
            mView.showError(mView.getViewContext().getString(R.string.failed_to_login_server));
        }

        @Override
        protected void onAuthFailure() {
            mView.hideProgress();
        }
    }

    private void handleLogInDataSuccess(UserEntity entity) {

        if(mView.getUserName().equals(entity.loginName)&& (entity.token!=null && !entity.token.isEmpty())) {
            saveLoginCredentials(entity);
            if(preferenceService.getUserLang().isEmpty()) {
                mView.setApplicationLanguage(entity.defaultLanguage);
            }
            else
            {
                mView.setApplicationLanguage(preferenceService.getUserLang());
            }

            mView.navigateToPage();
        }
        else
        {
            mView.showError(mView.getViewContext().getString(R.string.failed_to_login));
        }
    }

    private void saveLoginCredentials(UserEntity entity)
    {

        preferenceService.setToken(entity.token);
        preferenceService.setUserName(entity.loginName);
        preferenceService.setUserId(entity.userId);
        if(preferenceService.getUserLang().isEmpty())
        {
            preferenceService.setUserLang(entity.defaultLanguage);
        }

    }

}
