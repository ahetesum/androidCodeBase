package com.connect.rh.data.repository;


import android.content.Context;

import com.connect.rh.data.entities.mapper.EntityMapper;
import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.net.RestApi;
import com.connect.rh.data.net.RestApiImpl;

public class NetworkRepository implements INetworkRepository {
    private RestApi restApi;

    public NetworkRepository(Context context, EntityMapper jsonMapper) {
        this.restApi = new RestApiImpl(context, jsonMapper);
    }


    @Override
    public Entity performLogIn(String body) throws Exception {
        return restApi.performLogIn(body);
    }

    @Override
    public Entity getProfile(String body) throws Exception {
        return restApi.getProfile(body);
    }
}
