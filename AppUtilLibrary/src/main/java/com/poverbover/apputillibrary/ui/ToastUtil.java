package com.poverbover.apputillibrary.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.poverbover.apputillibrary.AppUtil;
import com.poverbover.apputillibrary.R;

/**
 * 管理toast的工具类
 * 防止toast重叠或队列产生
 */
public class ToastUtil {

    private static Context context;
    private static Toast toast;
    private static ViewHolder holder;

    private ToastUtil() throws Exception {
        throw new Exception("ToastUtil can not be created");
    }

    /**初始化*/
    public static void init(){
        //需要先给context赋值
        context=AppUtil.getAppContext();
        holder=new ViewHolder();
    }

    /**显示toast
     * 仅限内部调用*/
    private static void show(String message,boolean center,int duration,boolean error){
        if(toast!=null)hide();
        toast=new Toast(context);
        toast.setView(holder.rootView);
        holder.tvMessage.setText(message);
        if(error)holder.error();
        if(center)toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(duration);
        toast.show();
    }

    /**隐藏toast*/
    public static void hide(){
        if(toast!=null)toast.cancel();
    }

    public static void show(String message){showBottom(message);}
    public static void showBottom(String message){
        show(message, false,Toast.LENGTH_SHORT,false);
    }
    public static void showBottomLong(String message){show(message,false,Toast.LENGTH_LONG,false);}
    public static void showCenter(String message){show(message,true,Toast.LENGTH_SHORT,false);}
    public static void showCenterLong(String message){show(message,true,Toast.LENGTH_LONG,false);}
    public static void errorBottom(String message){show(message,false,Toast.LENGTH_SHORT,true);}
    public static void errorBottomLong(String message){show(message,false,Toast.LENGTH_LONG,true);}
    public static void errorCenter(String message){show(message,true,Toast.LENGTH_SHORT,true);}
    public static void errorCenterLong(String message){show(message,true,Toast.LENGTH_LONG,true);}
    //TODO 显示自定义view的toast

    /**定制toast显示风格*/
    static class ViewHolder{
        View rootView;
        TextView tvMessage;

        public ViewHolder(){
            rootView= LayoutInflater.from(context).inflate(R.layout.layout_toast,null);
            tvMessage= (TextView) rootView.findViewById(R.id.tv_message);
        }

        /**错误信息，背景为红色*/
        public ViewHolder error(){
            rootView.setBackgroundResource(R.drawable.toast_back_red);
            return this;
        }

        /**常规信息，背景为黑色*/
        public ViewHolder normal(){
            rootView.setBackgroundResource(R.drawable.toast_back_black);
            return this;
        }
    }
}
