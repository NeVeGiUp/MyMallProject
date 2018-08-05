package com.lgh.havehui.allpackage.utils;


import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lgh.havehui.R;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public class LoadDialog {


    private Dialog dialog;
    private TextView textView;
    public LoadDialog(Context context , String text){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialogview, null);// 得到加载view
        textView = (TextView)v.findViewById(R.id.dialogview_text);
        if(!TextUtils.isEmpty(text))
            textView.setText(text);

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


    public void setText(String text) {
        textView.setText(text);
    }

}
