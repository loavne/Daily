package com.poverbover.daily;

import android.app.Application;
import android.content.Context;

import com.poverbover.apputillibrary.AppUtil;

/**
 * Created by void on 2016/9/6.
 */
public class DailyApplication extends Application{

    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        AppUtil.init(this,AppConfig.DEBUG);
    }

    /**获取应用级context*/
    public static Context getAppContext(){
        return instance;
    }
}
