package com.lgh.havehui.allpackage.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public class MyLog {
    //测试环境才打印日志
    private static boolean isTest = true;
    public static final String tag = "info";

    public static void tlog(String tag, String text){
        if(isTest) {
            if (!TextUtils.isEmpty(text)) {
                Log.d(tag, text);
            }

        }
    }
}
