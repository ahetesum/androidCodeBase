package com.connect.rh.data.entities.mapper;

import org.json.JSONObject;

import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.UserEntity;

/**
 * Created by Ali on 2/26/2017.
 */

public class LogInMapper extends EntityMapper {
    private UserEntity userEntity = null;

    public LogInMapper() {
        userEntity = new UserEntity();
    }

    @Override
    public Entity transform(String jsonResponse) {
        try {
            JSONObject loginObject = new JSONObject(jsonResponse);
            trasformCommonValues(userEntity, loginObject);
            userEntity.userId = loginObject.optString("userId");
            userEntity.loginName = loginObject.optString("loginName");
            userEntity.defaultLanguage = loginObject.optString("defaultLanguage");
            userEntity.email = loginObject.optString("email");
            JSONObject accessTokenJsonObject=loginObject.optJSONObject("accessToken");
            if(accessTokenJsonObject!=null) {
                userEntity.token = accessTokenJsonObject.optString("access_token");
                userEntity.expiredTime = accessTokenJsonObject.optString("expiredTime");
            }
            return userEntity;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
