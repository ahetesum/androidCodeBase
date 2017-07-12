package com.connect.rh.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by 80056 on 2/22/2017.
 */

public class PreferenceService {
    private static final String KEY_TOKEN = "TOKEN";
    private static final String KEY_USERNAME = "USER_NAME";
    private static final String KEY_USERID = "USER_ID";
    private static final String KEY_USERLANG = "USER_LANG";
    private static String KEY_PRRFERENCE_NAME = "app.connect.mitolink.rh.com.app";

    private static SharedPreferences sharedPreferences;
    private static PreferenceService preference;

    public PreferenceService(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getApplicationContext().getSharedPreferences(KEY_PRRFERENCE_NAME, Context.MODE_PRIVATE);
        }
    }

    public static PreferenceService getInstance(Context context) {
        if (preference == null) {
            preference = new PreferenceService(context);
        }
        return preference;
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }

    public void setUserId(String userId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERID, userId);
        editor.commit();
    }

    public String getUserId() {
        return sharedPreferences.getString(KEY_USERID, "");
    }

    public void setUserLang(String lang) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERLANG, lang);
        editor.commit();
    }

    public String getUserLang() {
        return sharedPreferences.getString(KEY_USERLANG, "");
    }

    public String getToken() {
        return sharedPreferences.getString(KEY_TOKEN, "");
    }

    public void clearPreferences() {
        sharedPreferences.edit().clear().commit();
    }

    public void setUserName(String userName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }
}
