package com.aka.adnot.Handlers;

import android.util.Log;

import com.aka.adnot.enums.LogType;

/**
 * Created by S.Masoud on 2016/08/26.
 */
public class AdNotLogHandler {
    static String tag= "com.aka.adnot";

    public static void Log(LogType logType, String message){
        switch (logType) {
            case DEBUG:
                Log.d(tag,message);
                break;
            case INFO:
                Log.i(tag,message);
                break;
            case WARNING:
                Log.w(tag,message);
                break;
            case ERROR:
                Log.e(tag,message);
                break;
        }


    }
}
