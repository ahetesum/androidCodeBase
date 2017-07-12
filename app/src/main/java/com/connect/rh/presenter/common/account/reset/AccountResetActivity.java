package com.connect.rh.presenter.common.account.reset;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.connect.rh.R;
import com.connect.rh.presenter.abstractions.RHActivity;
import com.connect.rh.presenter.abstractions.RHApplication;
import com.connect.rh.utils.ValidationHelper;


public class AccountResetActivity extends RHActivity implements AccountResetView, View.OnClickListener {

    Toolbar toolbar =null;
    private RHApplication application=null;
    private Button deleteAccountButton=null;
    private CheckBox agreeCheckBox=null;
    private EditText passwordEditText=null;
    private AccountResetPresenter presenter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_reset);
        initializeUI();


    }

    @Override
    public void login()
    {
        //TODO:: perform login and validation
        presenter.performLogin();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }


    @Override
    public void initializeUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_account_reset);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        application=(RHApplication)this.getApplication();

        deleteAccountButton=(Button)findViewById(R.id.reset_acc_continue_button);
        agreeCheckBox=(CheckBox)findViewById(R.id.reset_acc_agree_chk);
        passwordEditText=(EditText)findViewById(R.id.reset_acc_account_edit);
        deleteAccountButton.setOnClickListener(this);


        presenter=new AccountResetPresenter(this);
        passwordEditText.setHint(String.format(passwordEditText.getHint().toString(),presenter.getUserName()));
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
        View decorView = getWindow().getDecorView();
        Snackbar.make(decorView,message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Context getViewContext() {
        return this;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar actions click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.reset_acc_continue_button:
                if(agreeCheckBox.isChecked())
                {
                    if(ValidationHelper.isEmpty(passwordEditText,getResources().getString(R.string.validation_empty_text))) {
                        login();
                    }
                }
                else
                {
                    showError(this.getApplicationContext().getString(R.string.reset_agree_error));
                }
                break;
        }
    }
}
