package com.poverbover.apputillibrary;

import android.util.Log;

/**Log工具，根据debug状态控制是否输出log
 */
public class LogUtil {

    private static final boolean debug=AppUtil.isDebug();

    private LogUtil() throws Exception {throw new Exception("LogUtil can not be created");}

    public static final void d(String tag,String msg){
        if(debug)Log.d(tag, msg);
    }
    public static final void e(String tag,String msg){
        if(debug)Log.e(tag,msg);
    }

}
