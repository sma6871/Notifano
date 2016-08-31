package com.aka.adnot.models;

import java.util.List;

/**
 * Created by S.Masoud on 2016/08/27.
 */
public class NotificationResponse {
    List<NotificationModel> notifications;

    public List<NotificationModel> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationModel> notifications) {
        this.notifications = notifications;
    }
}
