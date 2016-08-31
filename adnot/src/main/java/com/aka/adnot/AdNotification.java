package com.aka.adnot;

import android.content.Context;

import com.aka.adnot.Handlers.AdNotLogHandler;
import com.aka.adnot.enums.LogType;
import com.aka.adnot.utils.PackageData;


/**
 * Created by S.Masoud on 2016/08/20.
 */
public class AdNotification {

    Context context;
    String apiKey;

   // private static final long REPEAT_TIME = 1000 * 30;


    public AdNotification(Context context,String ApiKey) {
        this.context = context;
        apiKey=ApiKey;
        PackageData.getInstance().context=context;
        PackageData.getInstance().setApiKey(apiKey);
    }

    // Check api key format
    private boolean checkApiKeyFormat() {
        if(apiKey.length()==0)
            return false;
        return true;
    }

    // Start Ad notification service
    public void Start() {
        if (checkApiKeyFormat()) {
            AdNotificationAlarm alarm = new AdNotificationAlarm(context);
            // Start the alarm
            alarm.setRecurringAlarm();
        } else {
            AdNotLogHandler.Log(LogType.ERROR,"API key is not valid.");
        }
    }

    // Stop Ad notification service
    public void Stop() {
        if (checkApiKeyFormat()) {
            AdNotificationAlarm alarm = new AdNotificationAlarm(context);
            alarm.stopAlarm();
        } else {
            AdNotLogHandler.Log(LogType.ERROR,"API key is not valid.");
        }
    }

}
