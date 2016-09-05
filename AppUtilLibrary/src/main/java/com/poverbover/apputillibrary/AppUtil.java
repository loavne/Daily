package com.poverbover.apputillibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.poverbover.apputillibrary.ui.ToastUtil;

/**
 * 应用工具类
 * 为该module提供context引用
 * 为app提供SharedPreferences接口
 */
public class AppUtil {

    private static boolean isDebug =true;
    private static Context appContext;
    private static SharedPreferences preferences;

    private AppUtil() throws Exception {
        throw new Exception("AppUtil can not be created");
    }

    /***
     * 初始化
     * @param appContext Application的实例
     */
    public static void init(Context appContext,boolean isdebug){
        AppUtil.appContext=appContext;
        AppUtil.isDebug =isdebug;
        ToastUtil.init();
        preferences=appContext.getSharedPreferences(appContext.getPackageName(), Context.MODE_PRIVATE);
    }

    /**获取应用级context引用*/
    public static Context getAppContext(){
        return appContext;
    }

    /**是否是debug模式*/
    public static boolean isDebug(){
        return isDebug;
    }

    /**保存到SharedPreferences
     * 已兼容基本类型*/
    public static void savePreference(String key,Object value){
        if(key==null||value==null)return;
        SharedPreferences.Editor edit = preferences.edit();
        if(value instanceof String){
            edit.putString(key,(String)value);
        }else if(value instanceof Boolean){
            edit.putBoolean(key,(Boolean)value);
        }else if(value instanceof Float){
            edit.putFloat(key,(Float) value);
        }else if(value instanceof Integer){
            edit.putInt(key,(Integer)value);
        }else if(value instanceof Long){
            edit.putLong(key,(Long)value);
        }
        edit.commit();
    }

    /**获取SharedPreferences实例*/
    public static SharedPreferences getPreferences(){
        return preferences;
    }

}
