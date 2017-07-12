package com.connect.rh.presenter.common.profile;

import com.connect.rh.data.database.DbService;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.presenter.abstractions.Presenter;

/**
 * Created by Ali on 4/30/2017.
 */

public class ProfilePresenter extends Presenter
{
    private ProfileView mView=null;
    private DbService dbService=null;
    private PreferenceService preferenceService=null;

    public ProfilePresenter(ProfileView view) {
        super(view);
        this.mView=view;
        dbService=DbService.getInstance();
        preferenceService=PreferenceService.getInstance(mView.getViewContext());
        setProfileData();
    }

    private void setProfileData()
    {
        String _id=preferenceService.getUserId();
        StaffEntity entity=dbService.getStaffEntity(_id);
        mView.setProfileData(entity);
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
}
