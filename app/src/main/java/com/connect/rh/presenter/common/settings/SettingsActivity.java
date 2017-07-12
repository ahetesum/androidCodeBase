package com.connect.rh.presenter.common.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.connect.rh.R;
import com.connect.rh.presenter.abstractions.RHApplication;

public class SettingsActivity extends AppCompatActivity implements SettingsView, View.OnClickListener {

    private RHApplication rhApplication=null;
    private SettingsPresenter settingsPresenter=null;
    private RelativeLayout englishLayout=null;
    private RelativeLayout farshiLayout=null;
    private CheckBox englishCheckBox=null;
    private CheckBox farshiCheckBox=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initializeUI();

    }

    @Override
    public void changeDefaultLanguage(String lang)
    {
       // showError(getResources().getString(R.string.chamge_lang_warning));
        settingsPresenter.resetLanguage(lang);

    }

    @Override
    public void logOut() {

    }

    @Override
    public void initializeUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.settings_text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rhApplication=(RHApplication)getApplicationContext();
        settingsPresenter=new SettingsPresenter(this);


        englishLayout=(RelativeLayout)findViewById(R.id.settings_english_layout);
        farshiLayout=(RelativeLayout)findViewById(R.id.settings_farshi_layout);
        englishCheckBox=(CheckBox)findViewById(R.id.settings_english_chk);
        farshiCheckBox=(CheckBox)findViewById(R.id.settings_farshi_chk);
        englishLayout.setOnClickListener(this);
        farshiLayout.setOnClickListener(this);
        englishCheckBox.setOnClickListener(this);
        farshiCheckBox.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(rhApplication.getAppLanguage().equalsIgnoreCase("fa"))
        {
            farshiCheckBox.setChecked(true);
            englishCheckBox.setChecked(false);
        }
        else
        {
            englishCheckBox.setChecked(true);
            farshiCheckBox.setChecked(false);
        }
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
    public ProgressDialog showProgress(String message) {
        return null;
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        View decorView = getWindow().getDecorView();

        Snackbar snackBar=Snackbar.make(decorView,message, Snackbar.LENGTH_LONG);
        View snackBarView = snackBar.getView();
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.colorWarning));
        snackBar.show();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.settings_english_layout:
                englishCheckBox.performClick();
                break;
            case R.id.settings_farshi_layout:
                farshiCheckBox.performClick();
                break;
            case R.id.settings_english_chk:
                if(englishCheckBox.isChecked()) {
                    changeDefaultLanguage("en");
                    if (farshiCheckBox.isChecked()) {
                        farshiCheckBox.setChecked(false);
                    }
                }
                else
                {
                    englishCheckBox.setChecked(true);
                }
                break;
            case R.id.settings_farshi_chk:
                if(farshiCheckBox.isChecked()) {
                    changeDefaultLanguage("fa");
                    if (englishCheckBox.isChecked()) {
                        englishCheckBox.setChecked(false);
                    }
                }
                else
                {
                    farshiCheckBox.setChecked(true);
                }
                break;
        }
    }
}
