package com.lgh.havehui.allpackage.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lhh
 * DATE 2017/4/1.
 */

public class MyToast {
    private boolean isdebug = true;

    public static void toast(Context context, String str){
        Toast.makeText(context,str, Toast.LENGTH_SHORT).show();
    }



}
