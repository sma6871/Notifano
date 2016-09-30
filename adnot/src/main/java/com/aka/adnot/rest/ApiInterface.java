package com.aka.adnot.rest;

import com.aka.adnot.models.NotificationModel;
import com.aka.adnot.models.NotificationRequestModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by S.Masoud on 2016/08/26.
 */
public interface ApiInterface {

    @POST("GetNotifications")
    Call<List<NotificationModel>> getNewNotifications(@Body NotificationRequestModel notificationRequestModel);

}
