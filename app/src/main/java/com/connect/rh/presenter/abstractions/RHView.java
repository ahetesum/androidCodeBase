package com.connect.rh.presenter.abstractions;

import android.app.ProgressDialog;
import android.content.Context;

import com.connect.rh.data.entities.entities.Entity;

/**
 * Created by 80056 on 2/22/2017.
 */

public interface RHView {

    void initializeUI();

    /**
     * Implement this to return the title of the which should be show when this Fragment is shown
     *
     * @return String to set title null or empty string to no to change existing title
     */
    String onSetTitle();

    /**
     * Implement this to show back Button as home to navigate back.
     *
     * @return Return true to show back Button or false will show menu button.
     */
    boolean hasBackButton();

    /**
     * Call this method to show circular indefinate pregress bar with a message.
     * There must be equal no of @link hideProgress() calls to hide progress bar.
     * Implement this to show your custom progress. By default indefinate circular
     * progress will be shown with message
     */
    ProgressDialog showProgress(String message);

    /**
     * Call this method to hide the progress dialog previosly shown.
     * Hides the pregress shown. To this to work there must be equal no. of call to show progress
     *
     * @paramm message Message to be displayed.
     */
    void hideProgress();

    /**
     * Call this method to show error in toast.
     * Implement this method to show custom error.
     * By default a toast with error message will be shown
     *
     * @param message Message to be displayed.
     */
    void showError(String message);

    /**
     * Call this method to get the context of the activity or fragment implementing this view.
     *
     * @return Context of the activity or fragment
     */
    Context getViewContext();



}
