package com.lgh.havehui.allpackage.base;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/27.
 */
public interface BasePresenter<T> {

    void onSuccess(T data);
    //数据加载失败
    void onFailed(String msg);
}
