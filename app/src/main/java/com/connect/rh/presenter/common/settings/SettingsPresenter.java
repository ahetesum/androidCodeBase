package com.connect.rh.presenter.common.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.domain.interactor.common.LogOutInteractor;
import com.connect.rh.presenter.abstractions.Presenter;
import com.connect.rh.presenter.abstractions.RHView;
import com.connect.rh.presenter.common.restart.RestartActivity;

import java.util.Locale;

/**
 * Created by Ali on 5/20/2017.
 */

public class SettingsPresenter extends Presenter
{
    private SettingsView mView=null;
    private PreferenceService preferenceService=null;
    private LogOutInteractor logOutInteractor=null;

    public SettingsPresenter(SettingsView view) {
        super(view);
        this.mView=view;
        this.preferenceService=PreferenceService.getInstance(mView.getViewContext());
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

    public void resetLanguage(String lang)
    {
        Intent resrtartIntent=new Intent(mView.getViewContext(),RestartActivity.class);
        resrtartIntent.putExtra("LANG",lang);
        mView.getViewContext().startActivity(resrtartIntent);

    }
}
