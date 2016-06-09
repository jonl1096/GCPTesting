package com.example.jliu.gcp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.plus.Plus;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jliu on 6/7/2016.
 */
public class GcpManager {

    private String uri;
    private String method = "GET";
    private Map<String, String> params;
    private String service;

    private static final String TAG = "RetrieveAccessToken";

    public GcpManager() {
        params = new HashMap<>();
    }

    public String getUri() {
        return uri;
    }

    public GcpManager setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public GcpManager setMethod(String method) {
        this.method = method;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }
    public GcpManager setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public GcpManager setParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public String getService() {
        return this.service;
    }

    public  GcpManager setService(String pService) {
        this.service = pService;
        return this;
    }

    public String getEncodedParams() {
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode(params.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key + "=" + value);
        }
        return sb.toString();
    }


}
