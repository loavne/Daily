package com.poverbover.apputillibrary.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.poverbover.apputillibrary.AppUtil;

/**
 * Created by void on 2016/9/5.
 */
public class BaseActivity extends AppCompatActivity{

    private final String tag=getClass().getSimpleName();
    /**记录最后一次点击的时间*/
    private long clickTime = 0;

    /**是否首次打开该activity*/
    private boolean isFirstOpen;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if(AppUtil.getPreferences().getBoolean(tag+"-FirstOpen",true)){
            AppUtil.savePreference(tag+"-FirstOpen",false);
            isFirstOpen=true;
        }else {
            isFirstOpen=false;
        }
    }

    /**是否首次打开该activity*/
    public boolean isFirstOpen(){
        return isFirstOpen;
    }

    /**双击退出*/
    public void exitApp() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            Toast.makeText(this, "再按一次后退键退出程序", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }
}
