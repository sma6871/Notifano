package com.aka.adnot;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by S.Masoud on 2016/08/26.
 */
class AdNotificationAlarm {
    Context context;

    public AdNotificationAlarm(Context context) {
        this.context = context;
    }

    public void setRecurringAlarm() {

        Intent downloader = new Intent(context,AdNotBroadcastReceiver.class);
        downloader.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, downloader, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,0 , 60000, pendingIntent);

        Log.d("MyActivity", "Set alarmManager.setRepeating to: " + AlarmManager.INTERVAL_FIFTEEN_MINUTES);

    }

    public void stopAlarm() {
        Intent downloader = new Intent(context,AdNotBroadcastReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, downloader, PendingIntent.FLAG_NO_CREATE);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);

    }
}
