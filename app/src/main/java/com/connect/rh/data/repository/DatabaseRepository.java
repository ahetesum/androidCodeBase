package com.connect.rh.data.repository;

import android.content.Context;

import com.connect.rh.data.database.DbService;
import com.connect.rh.data.entities.mapper.EntityMapper;

/**
 * Created by Ali on 2/26/2017.
 */

public class DatabaseRepository implements IDatabaseRepository {
    private DbService dbService = null;
    private EntityMapper entityMapper = null;

    public DatabaseRepository(Context context, EntityMapper jsonMapper) {
        this.dbService = DbService.getInstance();
        this.entityMapper = jsonMapper;
    }
}
