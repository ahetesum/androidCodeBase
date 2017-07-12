package com.connect.rh.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ali on 4/30/2017.
 */

public class JsonHelper
{
    public static String getLoginBody(String userName,String password)
    {
            JSONObject bodyObject = new JSONObject();
            try {
                bodyObject.put("loginName", userName);
                bodyObject.put("password",password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return bodyObject.toString();
    }
    public static String getProfileBody(String userName,String password)
    {
        JSONObject bodyObject = new JSONObject();
        try {
            bodyObject.put("loginName", userName);
            bodyObject.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bodyObject.toString();
    }
}
