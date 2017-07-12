package com.connect.rh.data.net.base;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.RequestBody;

/**
 * Created by kantesh on 6/26/15.
 */
public class HttpPostRequest extends HttpRequest {

    public HttpPostRequest(String url, String body) {
        super(url);
        setBody(body);
    }

    public void setBody(String body) {
        requestBuilder.post(RequestBody.create(JSON, body.toString()));
    }

    public void setBody(JSONObject body) {
        requestBuilder.post(RequestBody.create(JSON, body.toString()));
    }

    public void setBody(JSONArray jsonArray) {
        requestBuilder.post(RequestBody.create(JSON, jsonArray.toString()));
    }
}
