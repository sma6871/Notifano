package com.aka.adnot.models;

import com.aka.adnot.enums.NotificationType;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S.Masoud on 2016/08/26.
 */
public class NotificationModel {
    @SerializedName("Id")
    private int id;
    @SerializedName("Title")
    private String title;
    @SerializedName("Text")
    private String text;
    @SerializedName("Icon")
    private String icon;
    @SerializedName("Image")
    private String image;
    @SerializedName("Link")
    private String link;
    private NotificationType type;

    public NotificationModel(int id, String title, String text, String icon, String image, String link, NotificationType type) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.icon = icon;
        this.image = image;
        this.link = link;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
