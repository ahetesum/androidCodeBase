package com.connect.rh.presenter.abstractions;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.connect.rh.R;

public class RHActivity extends AppCompatActivity {

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rh);
    }

    public ProgressDialog showProgress(String msg) {
        if (progress == null) {
            createProgressDialog();
        }

        if(!progress.isShowing()) {
            progress.setMessage(msg);
            progress.show();
        }
        return progress;
    }

    private void createProgressDialog()
    {
        progress = new ProgressDialog(this);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setCancelable(false);
    }

    public void hideProgress() {
        if (progress != null && progress.isShowing())
        {
            progress.dismiss();
        }
    }


    public void hideKeyBoard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
