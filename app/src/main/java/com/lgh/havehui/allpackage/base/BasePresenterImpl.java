package com.lgh.havehui.allpackage.base;

import android.content.Context;

import com.lgh.havehui.allpackage.utils.SpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public abstract class BasePresenterImpl<T> {
    private   Context               context;
    protected Callback<BaseBean<T>> baseCallBack;


    public BasePresenterImpl(Context context) {
        this.context = context;
        init();
    }

    protected void init() {
        baseCallBack = new Callback<BaseBean<T>>() {
            @Override
            public void onResponse(Call<BaseBean<T>> call, Response<BaseBean<T>> response) {
                BaseBean<T> body = response.body();
                if (body != null) {
                    String status = body.getStatus();
                    if ("1".equals(status)) {
                        if (body.getData() != null) {

                            onSuccess(body.getData());
                        }

                    } else  {
                        //clear();
                        onFail(null);
                    }
                }
            }


            @Override
            public void onFailure(Call<BaseBean<T>> call, Throwable t) {
                onFail(t.getMessage());
            }


        };
    }

    private void clear() {
        SpUtils sp = new SpUtils(context);
        sp.putString(SpUtils.TOKEN, "");
        sp.clear();
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFail(String msg);


}
