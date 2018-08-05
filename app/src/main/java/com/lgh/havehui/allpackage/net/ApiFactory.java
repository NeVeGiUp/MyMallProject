package com.lgh.havehui.allpackage.net;//package network.enums;


/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public enum ApiFactory {
    INSTANCE;


   private final ApiService apiService;

   ApiFactory() {
       apiService = RetrofitClient.INSTANCE.getRetrofit().create(ApiService.class);
   }

   public ApiService getApiService() {
        return apiService;
   }

}
