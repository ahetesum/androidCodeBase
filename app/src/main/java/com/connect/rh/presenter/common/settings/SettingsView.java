package com.connect.rh.presenter.common.settings;

import com.connect.rh.presenter.abstractions.RHView;

/**
 * Created by Ali on 5/20/2017.
 */

public interface SettingsView extends RHView
{
     void changeDefaultLanguage(String lang);

    void logOut();
}
