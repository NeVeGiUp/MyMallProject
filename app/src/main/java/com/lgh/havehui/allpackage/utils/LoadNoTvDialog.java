package com.lgh.havehui.allpackage.utils;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lgh.havehui.R;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public class LoadNoTvDialog {


    private Dialog dialog;

    public LoadNoTvDialog(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialogview_notitle, null);// 得到加载view

        dialog = new Dialog(context, R.style.loading_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(v);

    }




    /***/
    public void show(){
        if(dialog != null && !dialog.isShowing())
            dialog.show();
    }
    
    public  void dismiss(){
    	if(dialog != null&&dialog.isShowing()){
    		dialog.dismiss();
    	}
    }


}
