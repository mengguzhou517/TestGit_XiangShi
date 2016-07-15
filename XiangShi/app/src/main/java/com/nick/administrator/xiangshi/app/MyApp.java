package com.nick.administrator.xiangshi.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyApp extends Application {
    public static Context mContext;
    private static final String shref_filename = "config";
    private static final String IS_FIRSTLOGIN = "isFirstLogin";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static boolean isFirstLogin(){
        SharedPreferences shref = mContext.getSharedPreferences(shref_filename,Context.MODE_PRIVATE);
        boolean isFirst = shref.getBoolean(IS_FIRSTLOGIN,true);
        if (isFirst){
            shref.edit().putBoolean(IS_FIRSTLOGIN,false).apply();
        }
        return isFirst;
    }
}
