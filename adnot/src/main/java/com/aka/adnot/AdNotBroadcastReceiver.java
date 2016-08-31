package com.aka.adnot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.aka.adnot.Handlers.AdNotLogHandler;
import com.aka.adnot.enums.LogType;
import com.aka.adnot.utils.PackageData;

/**
 * Created by S.Masoud on 2016/08/20.
 */
public class AdNotBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        PackageData.getInstance().context=context;
        NotificationService.startCheckForNotification(context);

        AdNotLogHandler.Log(LogType.INFO, "Called context.startService from AlarmReceiver.onReceive");
    }
}
