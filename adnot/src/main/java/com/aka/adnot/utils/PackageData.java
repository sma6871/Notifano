package com.aka.adnot.utils;

import android.content.Context;

import com.aka.adnot.helpers.SharedPreferenceHelper;

/**
 * Created by S.Masoud on 2016/08/27.
 */
public class PackageData {

    private String ApiKeyKey="ApiKey";
    private String PackageNameKey="PackageName";
    private String LastUpdateTimeKey ="LastUpdate";
    private String IsStaticTimeKey ="IsStaticTime";

    public Context context;
    private static PackageData instance;

    public static PackageData getInstance()
    {

        if(instance==null)
        {
            instance=new PackageData();
        }
        return instance;
    }

    // Private constructor for singleton pattern
    private PackageData() {  }

    // gets ApiKey that saved in shared preferences
    public String getApiKey() {
        return SharedPreferenceHelper.getSharedPreferenceString(context,ApiKeyKey,"");
    }

    // save ApiKey in shared preferences
    public void setApiKey(String apiKey) {
        SharedPreferenceHelper.setSharedPreferenceString(context,ApiKeyKey,apiKey);;
    }

    // get Package name of application from context
    public String getPackageName() {
        return context.getPackageName();
    }

    // get last update time that saved in shared preferences
    public long getLastUpdateTime() {
        return SharedPreferenceHelper.getSharedPreferenceLong(context, LastUpdateTimeKey, System.currentTimeMillis());
    }
    // save last update time in shared preferences
    public void setLastUpdateTime() {
        SharedPreferenceHelper.setSharedPreferenceLong(context, LastUpdateTimeKey, System.currentTimeMillis());
    }


    /*
    * For test purposes
    */
    public void SetIsStaticTime(boolean isStaticTime)
    {
        SharedPreferenceHelper.setSharedPreferenceBoolean(context,IsStaticTimeKey,isStaticTime);
    }
    public boolean GetIsStaticTime()
    {
        return SharedPreferenceHelper.getSharedPreferenceBoolean(context,IsStaticTimeKey,false);
    }
}
