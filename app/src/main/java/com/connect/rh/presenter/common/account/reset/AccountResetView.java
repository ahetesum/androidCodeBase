package com.connect.rh.presenter.common.account.reset;

import com.connect.rh.presenter.abstractions.RHView;

/**
 * Created by Ali on 5/6/2017.
 */

public interface AccountResetView extends RHView
{
    void login();

    String getPassword();
}
