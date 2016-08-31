package com.aka.adnot;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.aka.adnot.Handlers.AdNotLogHandler;
import com.aka.adnot.enums.LogType;
import com.aka.adnot.helpers.ConnectivityHelper;
import com.aka.adnot.models.NotificationModel;
import com.aka.adnot.utils.NotificationID;
import com.aka.adnot.utils.PabloPicasso;
import com.aka.adnot.utils.PackageData;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import br.com.goncalves.pugnotification.interfaces.ImageLoader;
import br.com.goncalves.pugnotification.interfaces.OnImageLoadingCompleted;
import br.com.goncalves.pugnotification.notification.Load;
import br.com.goncalves.pugnotification.notification.PugNotification;

/**
 * Created by S.Masoud on 2016/08/27.
 */
public class NotificationViewer implements ImageLoader {
    private Target viewTarget;
    private static Context _context;
    public void sendNotification(Context context, NotificationModel notificationModel) {
        _context=context;
        boolean isNew=false;

        int iconId=context.getApplicationInfo().icon;

        Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
        notificationIntent.setData(Uri.parse(notificationModel.getLink()));
        PendingIntent pi = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        Load mLoad = PugNotification.with(context).load()
                .smallIcon(iconId)
                .autoCancel(true)
                .largeIcon(iconId)
                .title(notificationModel.getTitle())
                .message(notificationModel.getText())
                .bigTextStyle(notificationModel.getText())
                .click(pi)
                .identifier(NotificationID.getID())
                .flags(Notification.DEFAULT_ALL);

        if(notificationModel.getImage().isEmpty())
        {
            mLoad.simple().build();
        }
        else {
            mLoad.custom()
                    .setImageLoader(NotificationViewer.this)
                    .background(notificationModel.getImage())
                    .setPlaceholder(R.drawable.pugnotification_ic_placeholder)
                    .build();
        }
        PackageData.getInstance().setLastUpdateTime();
    }

    private static Target getViewTarget(final OnImageLoadingCompleted onCompleted) {
        return new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                onCompleted.imageLoadingCompleted(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
    }
    @Override
    public void load(String uri, final OnImageLoadingCompleted onCompleted) {
        viewTarget = getViewTarget(onCompleted);
        if (!ConnectivityHelper.isAirplaneModeOn(_context))
            PabloPicasso.with(_context).load(uri)
                    .resize(256, 256)
                    .into(viewTarget);
        else AdNotLogHandler.Log(LogType.WARNING,"Airplane mode is on.");
    }

    @Override
    public void load(int imageResId, OnImageLoadingCompleted onCompleted) {
        viewTarget = getViewTarget(onCompleted);
        if (ConnectivityHelper.isAirplaneModeOn(_context))
            PabloPicasso.with(_context).load(imageResId).into(viewTarget);
        else AdNotLogHandler.Log(LogType.WARNING,"Airplane mode is on.");
    }
}
