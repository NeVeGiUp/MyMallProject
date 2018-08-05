package com.lgh.havehui.allpackage.activity;

import android.view.KeyEvent;

import com.lgh.havehui.allpackage.base.BaseActivity;
import com.lgh.havehui.allpackage.utils.MyToast;
import com.lgh.havehui.R;
/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */


public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        //更新版本操作

    }


/*    @Override
    protected String getATitle() {
        return null;
    }*/


    //声明一个long类型变量：用于存放上一点击“返回键”的时刻
    private long mExitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                MyToast.toast(this, "再按一次退出程序");
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                //System.exit(0);       //退出应用
                moveTaskToBack(false);//运行在后台
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
