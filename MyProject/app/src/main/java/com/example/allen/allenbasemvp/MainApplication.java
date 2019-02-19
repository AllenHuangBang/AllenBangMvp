package com.example.allen.allenbasemvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by allen on 2018/12/26.
 */
public class MainApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
