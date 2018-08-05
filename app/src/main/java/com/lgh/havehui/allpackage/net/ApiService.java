package com.lgh.havehui.allpackage.net;


import com.lgh.havehui.allpackage.base.BaseBean;
import com.lgh.havehui.allpackage.bean.HomeModuleBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public interface ApiService<T> {

    //首页菜单、广告、模块数据
    @FormUrlEncoded
    @POST("index/index_mbm")
    Call<BaseBean<HomeModuleBean>> loadHomeModuleData(@FieldMap Map<String, String> map);

}
