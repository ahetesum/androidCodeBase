package com.connect.rh.presenter.common.account.reset;

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
import com.connect.rh.utils.JsonHelper;

/**
 * Created by Ali on 5/6/2017.
 */

public class AccountResetPresenter extends Presenter
{
    private PreferenceService preferenceService=null;
    private AccountResetView mView=null;
    public AccountResetPresenter(AccountResetView view)
    {
        super(view);
        this.mView=view;
        this.preferenceService=PreferenceService.getInstance(mView.getViewContext());
        interactor = new LoginInteractor(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), new AccountResetPresenter.AccountResetSubscriber(authenticationHandler), new NetworkRepository(mView.getViewContext(), new LogInMapper()));
    }

    public String getUserName()
    {
        return preferenceService.getUserName();
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

    public void performLogin()
    {
        mView.showProgress(mView.getViewContext().getResources().getString(R.string.verify_credentials_text));
        ((LoginInteractor) interactor).performLogIn(JsonHelper.getLoginBody(preferenceService.getUserName(),mView.getPassword()));
    }


    private class AccountResetSubscriber extends ResponseSubscriber<UserEntity> {

        AccountResetSubscriber(AuthenticationHandler authenticationHandler) {
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

        if(preferenceService.getUserName().equals(entity.loginName)&& (entity.token!=null && !entity.token.isEmpty())) {
            mView.getViewContext().deleteDatabase("RHDatabase.db");
            preferenceService.clearPreferences();
            //TODO:: Restart the Application after this and give exact database name
        }
        else
        {
            mView.showError(mView.getViewContext().getString(R.string.failed_to_login));
        }
    }

}
