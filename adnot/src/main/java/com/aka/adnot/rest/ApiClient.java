package com.aka.adnot.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by S.Masoud on 2016/08/26.
 */
public class ApiClient {
    public static final String BASE_URL = "http://webpanel.notifano.ir/api/Notifications/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {

        if (retrofit==null) {
            OkHttpClient callfactory=new OkHttpClient()
                    .newBuilder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .callFactory(callfactory)
                    .build();
        }
        return retrofit;
    }
}
