package com.connect.rh.presenter.common.restart;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.domain.interactor.common.LogOutInteractor;
import com.connect.rh.presenter.abstractions.Presenter;
import com.connect.rh.presenter.abstractions.RHView;
import com.connect.rh.presenter.common.settings.SettingsView;

import java.util.Locale;

/**
 * Created by Ali on 5/21/2017.
 */

public class RestartPresenter extends Presenter
{

    private RestartView mView=null;
    private PreferenceService preferenceService=null;

    public RestartPresenter(RestartView view) {
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


    public void setDefaultLanguage(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        ((Activity)mView.getViewContext()).getBaseContext().getResources().updateConfiguration(config,
                ((Activity)mView.getViewContext()).getBaseContext().getResources().getDisplayMetrics());

        preferenceService.setUserLang(lang);
    }


}
