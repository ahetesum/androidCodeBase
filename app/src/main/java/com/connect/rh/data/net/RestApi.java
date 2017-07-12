package com.connect.rh.data.net;


import com.connect.rh.data.entities.entities.Entity;

public interface RestApi {


    Entity performLogIn(String body) throws Exception;

    Entity getProfile(String body) throws Exception;;
}
