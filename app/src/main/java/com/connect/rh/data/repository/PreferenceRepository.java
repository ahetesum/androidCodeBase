package com.connect.rh.data.repository;

import android.content.Context;

import com.connect.rh.data.entities.mapper.EntityMapper;
import com.connect.rh.data.preferences.PreferenceService;

public class PreferenceRepository implements IPreferenceRepository {

    private final PreferenceService preference;
    private final EntityMapper entityMapper;

    public PreferenceRepository(Context context, EntityMapper jsonMapper) {
        preference = PreferenceService.getInstance(context);
        entityMapper = jsonMapper;
    }

    @Override
    public String getAccessToken() {
        return preference.getToken();
    }
}
