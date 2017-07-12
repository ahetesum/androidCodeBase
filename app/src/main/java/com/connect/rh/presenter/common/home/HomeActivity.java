package com.connect.rh.presenter.common.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.connect.rh.R;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.presenter.abstractions.RHApplication;
import com.connect.rh.presenter.common.profile.ProfileActivity;
import com.connect.rh.presenter.common.settings.SettingsActivity;
import com.connect.rh.utils.StringHelper;
import com.mikhaellopez.circularimageview.CircularImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,HomeView {

    private NavigationView navigationView =null;
    private Toolbar toolbar =null;
    private RHApplication application=null;
    private RelativeLayout profNavLayout=null;
    private HomePresenter homePresenter=null;
    private CircularImageView profileImageView=null;
    private TextView profileNameTextView=null;
    private TextView positionNameTextView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeUI();

        homePresenter=new HomePresenter(this);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void initializeUI() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_home);
        application=(RHApplication)this.getApplication();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        profNavLayout=(RelativeLayout)headerView.findViewById(R.id.nav_profile_layout);
        profNavLayout.setOnClickListener(this);

        profileImageView=(CircularImageView)headerView.findViewById(R.id.nav_profile_img);
        profileNameTextView=(TextView)headerView.findViewById(R.id.nav_profile_name_text);
        positionNameTextView=(TextView)headerView.findViewById(R.id.nav_profile_pos_text);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_settings)
        {
            Intent settingsIntent=new Intent(HomeActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
       switch (v.getId())
       {
           case R.id.nav_profile_layout:
               Intent profileIntent=new Intent(HomeActivity.this,ProfileActivity.class);
               startActivity(profileIntent);
               break;
       }
    }

    @Override
    public void getProfileInfo() {

    }

    @Override
    public void setProfileInfo(Entity entity) {
        StaffEntity staffEntity=(StaffEntity)entity;
        //TODO:: set all param here
        profileNameTextView.setText(StringHelper.toCamelCase(staffEntity.getCompleteName(application.getAppLanguage())));
        positionNameTextView.setText(StringHelper.toCamelCase(staffEntity.getPositionName(application.getAppLanguage())));

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

    }

    @Override
    public Context getViewContext() {
        return this;
    }

}
