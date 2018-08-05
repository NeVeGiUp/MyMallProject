package com.lgh.havehui.allpackage.net;//package network.enums;


import com.lgh.havehui.allpackage.utils.MyLog;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */



public enum OKHttpFactory {

  INSTANCE;

  private final OkHttpClient okHttpClient;


   OKHttpFactory() {
       //日志显示级别
       HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
       HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
           @Override
           public void log(String message) {
               MyLog.tlog(MyLog.tag,"OkHttp====Message:"+message);
           }
       });
       loggingInterceptor.setLevel(level);

       okHttpClient = new OkHttpClient.Builder()
               .connectTimeout(15,TimeUnit.SECONDS)  //设置网络超时时间
               .writeTimeout(15, TimeUnit.SECONDS)   //写入超时
               .readTimeout(15, TimeUnit.SECONDS)    //读取超时

               //.cache(new Cache(directory, DEFAULT_CACHE_SIZE))
               .addInterceptor(loggingInterceptor)
//               .addInterceptor(new HeaderInterceptor(context))
//               .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
               .build();
   }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


}
