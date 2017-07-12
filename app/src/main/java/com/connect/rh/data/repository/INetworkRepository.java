package com.connect.rh.data.repository;

import com.connect.rh.data.entities.entities.Entity;

public interface INetworkRepository extends Repository {

    Entity performLogIn(String body) throws Exception;

    Entity getProfile(String body) throws  Exception;
}
