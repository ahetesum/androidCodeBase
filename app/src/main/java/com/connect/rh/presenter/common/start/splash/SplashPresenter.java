package com.connect.rh.presenter.common.start.splash;

import android.app.Activity;
import android.content.res.Configuration;

import com.connect.rh.data.preferences.PreferenceService;
import com.connect.rh.presenter.abstractions.Presenter;

import java.util.Locale;

/**
 * Created by Ali on 5/20/2017.
 */

public class SplashPresenter extends Presenter
{


    PreferenceService preferenceService=null;
    SplashView mView=null;

    public SplashPresenter(SplashView view)
    {
        super(view);
        this.mView=view;
        this.preferenceService=PreferenceService.getInstance(mView.getViewContext());
    }

    public void setDefaultLanguage()
    {

        String sysLang= Locale.getDefault().getDisplayLanguage();
        if(preferenceService.getUserLang().isEmpty() || preferenceService.getUserLang().equalsIgnoreCase("fa"))
        {
          //  forceDefaultLanguage("fa");
        }
    }

    private void forceDefaultLanguage(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        ((Activity)mView.getViewContext()).getBaseContext().getResources().updateConfiguration(config,
                ((Activity)mView.getViewContext()).getBaseContext().getResources().getDisplayMetrics());
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
