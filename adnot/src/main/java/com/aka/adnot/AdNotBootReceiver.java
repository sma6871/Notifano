package com.aka.adnot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by S.Masoud on 2016/08/30.
 */
public class AdNotBootReceiver extends BroadcastReceiver
{
    private static final String TAG = "MyBootReceiver";

    public void onReceive(Context context, Intent intent) {
        AdNotificationAlarm alarm = new AdNotificationAlarm(context);
        // Start the alarm
        alarm.setRecurringAlarm();
    }


}
