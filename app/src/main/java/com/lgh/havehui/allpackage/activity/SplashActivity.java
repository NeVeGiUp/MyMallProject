package com.lgh.havehui.allpackage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.lgh.havehui.R;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/11.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
                SplashActivity.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);//淡入淡出
                //overridePendingTransition(R.anim.anim_in,R.anim.anim_out);  //缩进动画
                //overridePendingTransition(R.anim.menu_bottombar_in2, 0);
            }
        }, 1000);
    }

}
