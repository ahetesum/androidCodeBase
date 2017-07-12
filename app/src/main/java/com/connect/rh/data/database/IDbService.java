package com.connect.rh.data.database;

import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.entities.entities.StaffEntity;
import com.connect.rh.data.entities.entities.UserEntity;

/**
 * Created by Ali on 3/4/2017.
 */

public interface IDbService {
    public static final int INVALID_REQUEST = -1;

    //UserTable Methods
    boolean isUserExist() throws Exception;

    Entity getUserInfo(long _id) throws Exception;

    long createUserInfo(UserEntity entity) throws Exception;

    long updateUserInfo(UserEntity entity) throws Exception;

    boolean deleteUserInfo(long _id) throws Exception;

    void createOrUpdate(StaffEntity entity) throws Exception;
}
