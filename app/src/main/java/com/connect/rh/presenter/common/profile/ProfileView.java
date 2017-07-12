package com.connect.rh.presenter.common.profile;

import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.presenter.abstractions.RHView;

/**
 * Created by Ali on 4/30/2017.
 */

public interface ProfileView extends RHView
{
    void setProfileData(Entity entity);
}
