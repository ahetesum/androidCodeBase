package com.connect.rh.data.net;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

import com.connect.rh.R;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.entities.entities.UserEntity;
import com.connect.rh.data.entities.mapper.EntityMapper;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.net.base.SessionManager;
import com.connect.rh.utils.NetworkHelper;
import com.connect.rh.utils.RHConstant;


public class RestApiImpl implements RestApi {

    private SessionManager sessionManager = null;
    private Context context = null;
    private EntityMapper entityMapper = null;


    public RestApiImpl(Context context, SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.context = context;
    }

    public RestApiImpl(Context context, EntityMapper entityMapper) {
        this.context = context;
        this.entityMapper = entityMapper;
    }

    @Override
    public Entity performLogIn(String body) throws Exception {
        try {

            if(RHConstant.IS_RUNNING_ONLINE)
            if (NetworkHelper.isThereInternetConnection(context)) {
                String responseUserEntities = null;
                try {
                    responseUserEntities = loginFromApi(body); //getLoginFromApi(body);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (responseUserEntities != null)
                {
                    return (Entity) entityMapper.transform(responseUserEntities);
                }
            } else {
                throw new Exception(context.getString(R.string.no_working_internet_connection));
            }
            else {
                InputStream is = context.getAssets().open("login.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String json = new String(buffer, "UTF-8");

                if (json != null) {
                    return (UserEntity) entityMapper.transform(json);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public Entity getProfile(String body) throws Exception {
        try {

            if(RHConstant.IS_RUNNING_ONLINE) {
                if (NetworkHelper.isThereInternetConnection(context)) {
                    String responseUserEntities = null;
                    try {
                        responseUserEntities = getProfileFromApi(body);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (responseUserEntities != null) {
                        return (Entity) entityMapper.transform(responseUserEntities);
                    }
                } else {
                    throw new Exception(context.getString(R.string.no_working_internet_connection));
                }
            }
            else
            {
                InputStream is = context.getAssets().open("viewStaff.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String json = new String(buffer, "UTF-8");

                if (json != null) {
                    return (StaffEntity) entityMapper.transform(json);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    private String getProfileFromApi(String body) throws Exception
    {
        String apiUrl = context.getString(R.string.base_profile_test_url);
        return ApiConnection.createPOST(apiUrl, body).call(sessionManager);
    }

    private String loginFromApi(String body) throws Exception {
        String apiUrl = context.getString(R.string.base_login_test_url);
        return ApiConnection.createPOST(apiUrl, body).call(sessionManager);
    }

}