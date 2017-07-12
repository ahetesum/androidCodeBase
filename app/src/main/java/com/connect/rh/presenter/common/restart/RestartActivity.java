package com.connect.rh.presenter.common.restart;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.connect.rh.R;

import java.util.Timer;
import java.util.TimerTask;

public class RestartActivity extends AppCompatActivity implements RestartView{

    private RestartPresenter restartPresenter=null;
    private TextView counterTextView=null;
    private Button cancelButton=null;
    private Timer timer=null;
    private int count=9;
    private String lang="";
    private boolean isBackPreeEnabled=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart);
        initializeUI();
        timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        counterTextView.setText(String.valueOf(count));
                        if(count!=0)
                            count--;
                        else
                        {
                            timer.cancel();
                            setDefaultLanguage(lang);
                            Intent i = getBaseContext().getPackageManager()
                                    .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                    }
                });
            }
        }, 1000, 1000);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
              isBackPreeEnabled=true;
                counterTextView.setText(R.string.stoped_text);
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(isBackPreeEnabled)
        {
            super.onBackPressed();
        }
    }

    @Override
    public void setDefaultLanguage(String lang)
    {
        restartPresenter.setDefaultLanguage(lang);
    }

    @Override
    public void initializeUI() {


        restartPresenter=new RestartPresenter(this);
        lang=getIntent().getExtras().getString("LANG");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.restarting_text);
        counterTextView=(TextView)findViewById(R.id.restart_counter_text);
        cancelButton=(Button)findViewById(R.id.restart_cancel_button);
        counterTextView.setText(R.string.start_text);
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
