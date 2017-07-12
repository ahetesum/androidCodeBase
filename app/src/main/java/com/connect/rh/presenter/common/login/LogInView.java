package com.connect.rh.presenter.common.login;

import com.connect.rh.presenter.abstractions.RHView;

/**
 * Created by Ali on 2/26/2017.
 */

public interface LogInView extends RHView {
    void performLogin();

    void navigateToPage();

    String getPassword();

    String getUserName();

    void navigateToAccountPage();

    void setApplicationLanguage(String defaultLanguage);
}
