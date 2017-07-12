package com.connect.rh.presenter.common.start.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.connect.rh.R;
import com.connect.rh.presenter.abstractions.RHActivity;
import com.connect.rh.presenter.common.start.intro.IntroActivity;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends RHActivity implements SplashView {


    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;
    private SplashPresenter splashPresenter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashPresenter=new SplashPresenter(this);
        splashPresenter.setDefaultLanguage();

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    @Override
    public void initializeUI() {

    }

    @Override
    public String onSetTitle() {
        return null;
    }

    @Override
    public boolean hasBackButton() {
        return false;
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getViewContext() {
        return this;
    }
}
