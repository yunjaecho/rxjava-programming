package com.yunjae.rxjava.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


/**
 * Created by USER on 2018-03-21.
 */
public class OkHttpHelper {
    private static OkHttpClient client = new OkHttpClient();
    private static final String ERROR = "ERROR";

    public static String get(String url) throws IOException {
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            Log.e(e.getMessage());
            throw e;
        }
    }

    public static String getT(String url) throws IOException {
        Request request = new Request
                .Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            Log.e(e.getMessage());
            throw e;
        }
    }

    public static String getWithLog(String url) throws IOException {
        Log.d("OkHttp call URL = " + url);
        return get(url);
    }

}
