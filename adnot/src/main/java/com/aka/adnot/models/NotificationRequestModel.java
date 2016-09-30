package com.aka.adnot.models;

/**
 * Created by S.Masoud on 2016/09/30.
 */
public class NotificationRequestModel {
    String apiKey;
    String packageName;
    long lastUpdateTime;
    String Code;

    public NotificationRequestModel(String apiKey, String packageName, long lastUpdateTime, String code) {
        this.apiKey = apiKey;
        this.packageName = packageName;
        this.lastUpdateTime = lastUpdateTime;
        Code = code;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
