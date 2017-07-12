package com.connect.rh.presenter.common.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.connect.rh.R;
import com.connect.rh.presenter.abstractions.RHActivity;
import com.connect.rh.presenter.abstractions.RHApplication;
import com.connect.rh.presenter.common.account.reset.AccountResetActivity;
import com.connect.rh.presenter.common.account.forgot.ForgotPasswordActivity;
import com.connect.rh.presenter.common.home.HomeActivity;
import com.connect.rh.utils.ValidationHelper;

public class LogInActivity extends RHActivity implements LogInView, View.OnClickListener {

    private RHApplication application=null;
    private LogInPresenter logInPresenter = null;
    private EditText userNameEditText = null;
    private EditText passwordEditText = null;
    private Button loginButton = null;
    private TextView forgotPasswordTextView = null;
    private TextView resetAccountTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initializeUI();
    }
    @Override
    public void initializeUI()
    {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().hide();
        application=(RHApplication)this.getApplication();

        userNameEditText = (EditText) findViewById(R.id.login_username_edit);
        passwordEditText = (EditText) findViewById(R.id.login_password_edit);
        loginButton = (Button) findViewById(R.id.login_login_button);
        forgotPasswordTextView = (TextView) findViewById(R.id.login_fpassword_text);
        resetAccountTextView=(TextView) findViewById(R.id.login_diffrent_text);
        loginButton.setOnClickListener(this);
        forgotPasswordTextView.setOnClickListener(this);
        resetAccountTextView.setOnClickListener(this);

        //TODO::Comment The below Code before release
        {
            userNameEditText.setText("systemadmin");
            passwordEditText.setText("password");
        }
        logInPresenter = new LogInPresenter(this);
        if(logInPresenter.userNameExists())
        {
            userNameEditText.setText(logInPresenter.getUserName());
            userNameEditText.setInputType(InputType.TYPE_NULL);
            userNameEditText.setEnabled(false);
        }
        else {
            resetAccountTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public void performLogin() {
        logInPresenter.performLogin();
    }

    @Override
    public void navigateToPage() {

        Intent authenticatedIntent = new Intent(LogInActivity.this, HomeActivity.class);
        startActivity(authenticatedIntent);
        LogInActivity.this.finish();
    }


    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }

    @Override
    public String getUserName() {
        return userNameEditText.getText().toString();
    }

    @Override
    public void navigateToAccountPage() {
        Intent accountIntent = new Intent(LogInActivity.this, AccountResetActivity.class);
        startActivity(accountIntent);
    }

    @Override
    public void setApplicationLanguage(String lang) {
        application.setAppLanguage(lang);
    }

    @Override
    public String onSetTitle() {
        return getResources().getString(R.string.login_login_text);
    }

    @Override
    public boolean hasBackButton() {
        return false;
    }

    @Override
    public ProgressDialog showProgress(String message) {
        return super.showProgress(message);
    }

    @Override
    public void hideProgress() {
        super.hideProgress();
    }

    @Override
    public void showError(String message) {
        View decorView = getWindow().getDecorView();
        Snackbar.make(decorView,message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login_button:
                hideKeyBoard();
                if (ValidationHelper.isEmpty(userNameEditText, getResources().getString(R.string.validation_empty_text)) &&
                        ValidationHelper.isEmpty(passwordEditText, getResources().getString(R.string.validation_empty_text))) {
                    performLogin();
                }
                break;
            case R.id.login_fpassword_text:
                Intent forgotPasswordIntent=new Intent(LogInActivity.this,ForgotPasswordActivity.class);
                startActivity(forgotPasswordIntent);
                break;
            case R.id.login_diffrent_text:
                navigateToAccountPage();
                break;
        }
    }


}
