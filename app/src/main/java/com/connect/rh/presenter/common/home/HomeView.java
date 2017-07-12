package com.connect.rh.presenter.common.home;

import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.presenter.abstractions.RHView;

/**
 * Created by Ali on 4/29/2017.
 */

public interface HomeView extends RHView
{
    void getProfileInfo();
    void setProfileInfo(Entity entity);
}
