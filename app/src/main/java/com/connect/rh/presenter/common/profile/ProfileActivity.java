package com.connect.rh.presenter.common.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.connect.rh.R;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.presenter.abstractions.RHActivity;
import com.connect.rh.presenter.abstractions.RHApplication;
import com.connect.rh.utils.StringHelper;


public class ProfileActivity extends RHActivity implements ProfileView {

    private  Toolbar toolbar =null;
    private RHApplication application=null;
    private ProfilePresenter profilePresenter=null;
    private TextView profileNameTextView=null;
    private TextView profilePosTextView=null;
    private TextView profileSeatTextView=null;
    private TextView profileDepartTextView=null;
    private TextView profilePhoneTextView=null;
    private TextView profileMobTextView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeUI();

    }

    @Override
    public void initializeUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        application=(RHApplication)this.getApplication();
        profileNameTextView=(TextView)findViewById(R.id.profile_username_text);
        profilePosTextView=(TextView)findViewById(R.id.profile_pos_text);

        profileSeatTextView=(TextView)findViewById(R.id.profile_seat_text);
        profileMobTextView=(TextView)findViewById(R.id.profile_mob_text);
        profilePhoneTextView=(TextView)findViewById(R.id.profile_phone_text);
        profileDepartTextView=(TextView)findViewById(R.id.profile_dept_text);

        profilePresenter=new ProfilePresenter(this);
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
    public void setProfileData(Entity entity) {
        StaffEntity staffEntity=(StaffEntity)entity;
        profileNameTextView.setText(StringHelper.toCamelCase(staffEntity.getCompleteName(application.getAppLanguage())));
        profilePosTextView.setText(StringHelper.toCamelCase(staffEntity.getDeapartmentName(application.getAppLanguage())));

        profileSeatTextView.setText(staffEntity.seatLocation);
        profileDepartTextView.setText(StringHelper.toCamelCase(staffEntity.getDeapartmentName(application.getAppLanguage())));
        profilePhoneTextView.setText(staffEntity.phoneNumber);
        profileMobTextView.setText(staffEntity.mobileNumber);
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
