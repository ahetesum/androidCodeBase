package com.connect.rh.data.entities.mapper;


import org.json.JSONObject;

import com.connect.rh.data.entities.entities.Entity;

/**
 * Created by Ahetesum on 6/22/2016.
 */
public abstract class EntityMapper {


    public abstract Entity transform(String jsonResponse);

    protected void trasformCommonValues(Entity entity, JSONObject jsonResponse) {

        entity.createTime=jsonResponse.optString("createTime");
        entity.updatedTime=jsonResponse.optString("updateTime");

        entity.status = jsonResponse.has("Status") ? jsonResponse.optString("Status") : jsonResponse.optString("status");
//        entity.dispMessage = jsonResponse.optString("dispMessage");
//        entity.HeaderMessage = jsonResponse.optString("HeaderMessage");
//        entity.AuthenticationStatus = jsonResponse.optString("AuthenticationStatus");
//        entity.timeStamp = jsonResponse.optString("timeStamp");
    }

}
