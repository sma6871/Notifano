package com.aka.adnot;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.aka.adnot.Handlers.AdNotLogHandler;
import com.aka.adnot.enums.LogType;
import com.aka.adnot.models.NotificationModel;
import com.aka.adnot.models.NotificationRequestModel;
import com.aka.adnot.rest.ApiClient;
import com.aka.adnot.rest.ApiInterface;
import com.aka.adnot.utils.PackageData;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationService extends IntentService {

    private static final String ACTION_CHECK_NOTIFICATION_AD = "com.aka.adnot.action.CHKAD";


    public NotificationService() {
        super("CheckForNotificationService");
    }


    public static void startCheckForNotification(Context context) {
        Intent intent = new Intent(context, NotificationService.class);
        intent.setAction(ACTION_CHECK_NOTIFICATION_AD);
        context.startService(intent);
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CHECK_NOTIFICATION_AD.equals(action)) {
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                checkForNewNotification();
            }
        }
    }

    /**
     * Method to check service for new notifications
     */
    private void checkForNewNotification() {

        try {

            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            String id = get_dev_id();
            Call<List<NotificationModel>> call =
                    apiService.getNewNotifications(
                            new NotificationRequestModel(
                                    PackageData.getInstance().getApiKey(),
                                    PackageData.getInstance().getPackageName().replace(".", "-"),
                                    PackageData.getInstance().GetIsStaticTime() ? System.currentTimeMillis() - 800000000 : PackageData.getInstance().getLastUpdateTime()
                                    , id));

            //AdNotLogHandler.Log(LogType.INFO, "MASOUD: " + (PackageData.getInstance().GetIsStaticTime() ? System.currentTimeMillis() - 800000000 : PackageData.getInstance().getLastUpdateTime()));

            call.enqueue(new Callback<List<NotificationModel>>() {
                @Override
                public void onResponse(Call<List<NotificationModel>> call, Response<List<NotificationModel>> response) {
                    if (!response.isSuccessful()) {
                        try {
                            AdNotLogHandler.Log(LogType.ERROR, response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    List<NotificationModel> notifications = response.body();
                    AdNotLogHandler.Log(LogType.INFO, "Number of notifications received: " + notifications.size());

                    for (NotificationModel notification : notifications) {

                        NotificationViewer notificationViewer = new NotificationViewer();
                        notificationViewer.sendNotification(PackageData.getInstance().context, notification);

                    }

                }

                @Override
                public void onFailure(Call<List<NotificationModel>> call, Throwable t) {
                    // Log error here since request failed
                    AdNotLogHandler.Log(LogType.ERROR,
                            t.toString());
                }
            });

        } catch (Exception ex) {
        }
    }


    static {
        System.loadLibrary("hello-jni");
    }
    public native String get_dev_id();

}
