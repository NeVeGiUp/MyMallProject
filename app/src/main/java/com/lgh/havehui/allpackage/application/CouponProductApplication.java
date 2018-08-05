package com.lgh.havehui.allpackage.application;

import android.app.Application;
import android.content.Context;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.base.ActivityManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;


/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public class CouponProductApplication extends Application {


    private static CouponProductApplication appContext;
    private        ActivityManager          activityManager;
    public static  String                   mobileName;
    public static  String                   CACHE_PATH;

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mobileName = android.os.Build.MANUFACTURER;
        mobileName = mobileName.toLowerCase();


        activityManager = ActivityManager.getInstance(); //

        appContext = this;


    }

        static {
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
                @Override
                public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                    layout.setPrimaryColorsId(R.color.colorWhite, R.color.colorBlack6);//全局设置主题颜色
                    return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
                }
            });
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
                @Override
                public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                    //指定为经典Footer，默认是 BallPulseFooter
                    return new ClassicsFooter(context).setDrawableSize(20);
                }
            });
    }


    public static CouponProductApplication getInstance() {
        return appContext;
    }
}
