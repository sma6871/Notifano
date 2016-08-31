package com.aka.adnot.rest;

import com.aka.adnot.models.NotificationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by S.Masoud on 2016/08/26.
 */
public interface ApiInterface {

    @GET("GetNotifications/{api_key}/{package}/{lasttime}")
    Call<List<NotificationModel>> getNewNotifications(@Path("api_key") String apiKey, @Path("package") String packageName,@Path("lasttime") long lastUpdateTime);

}
