package com.connect.rh.presenter.common.home;

import com.connect.rh.data.database.DbService;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.entities.mapper.StaffMapper;
import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.data.repository.NetworkRepository;
import com.connect.rh.domain.executor.impl.MainThreadImpl;
import com.connect.rh.domain.executor.impl.ThreadExecutor;
import com.connect.rh.domain.interactor.ResponseSubscriber;
import com.connect.rh.domain.interactor.common.ProfileInteractor;
import com.connect.rh.presenter.abstractions.Presenter;
import com.connect.rh.utils.AuthenticationHandler;
import com.connect.rh.utils.JsonHelper;

/**
 * Created by 80056 on 2/22/2017.
 */

public class HomePresenter extends Presenter
{

    private ProfileInteractor profileInteractor=null;
    private HomeView mView=null;
    private DbService dbService=null;
    private PreferenceService preferenceService=null;

    public HomePresenter(HomeView view) {
        super(view);
        this.mView=view;
        dbService=DbService.getInstance();
        preferenceService=PreferenceService.getInstance(mView.getViewContext());
        profileInteractor = new ProfileInteractor(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), new HomePresenter.ProfileDataSubscriber(authenticationHandler), new NetworkRepository(mView.getViewContext(), new StaffMapper()));
        getProfileData();
    }

    public void getProfileData()
    {
        if(dbService.isStaffExist())
        {
            Entity entity=dbService.getStaffEntity(preferenceService.getUserId());
            handleProfileDataSuccess(entity);
        }
        else {
            profileInteractor.getProfileData(JsonHelper.getProfileBody("test", "test"));
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

    public class ProfileDataSubscriber extends ResponseSubscriber {
        public ProfileDataSubscriber(AuthenticationHandler authenticationHandler) {
            super(authenticationHandler);
        }

        @Override
        protected void onSuccess(Entity entity) {
            handleProfileDataSuccess(entity);
            dbService.createOrUpdate((StaffEntity) entity);
        }

        @Override
        protected void onFailure(String error) {

        }

        @Override
        protected void onAuthFailure() {

        }
    }

    private void handleProfileDataSuccess(Entity entity)
    {
        mView.setProfileInfo(entity);
    }
}
