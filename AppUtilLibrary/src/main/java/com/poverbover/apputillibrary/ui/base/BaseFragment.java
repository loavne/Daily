package com.poverbover.apputillibrary.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poverbover.apputillibrary.AppUtil;

/**
 * Created by void on 2016/9/5.
 */
public class BaseFragment extends android.support.v4.app.Fragment{

    private final String tag=getClass().getSimpleName();
    /**是否首次打开该activity*/
    private boolean isFirstOpen;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(AppUtil.getPreferences().getBoolean(tag+"-FirstOpen",true)){
            AppUtil.savePreference(tag+"-FirstOpen",false);
            isFirstOpen=true;
        }else {
            isFirstOpen=false;
        }
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    public boolean isFirstOpen(){
        return isFirstOpen;
    }
}
