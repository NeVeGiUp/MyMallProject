package com.lgh.havehui.allpackage.net;//package network.enums;


import com.lgh.havehui.allpackage.global.Global;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public enum RetrofitClient {
    INSTANCE;

    private final Retrofit retrofit;

    RetrofitClient() {
        retrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.INSTANCE.getOkHttpClient())

               //baseUrl
                .baseUrl(Global.BASEURL)

               //gson转化器
                .addConverterFactory(GsonConverterFactory.create())

               .build();
    }

   public Retrofit getRetrofit() {
        return retrofit;
   }
}
