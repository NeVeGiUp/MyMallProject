package com.lgh.havehui.allpackage.presenterimpl;

import android.content.Context;

import com.lgh.havehui.allpackage.base.BaseBean;
import com.lgh.havehui.allpackage.base.BasePresenterImpl;
import com.lgh.havehui.allpackage.bean.HomeModuleBean;
import com.lgh.havehui.allpackage.net.ApiFactory;
import com.lgh.havehui.allpackage.presenter.HomeModulePresenter;

import java.util.Map;

import retrofit2.Call;


public class HomeModulePresenterImpl extends BasePresenterImpl<HomeModuleBean> {
    HomeModulePresenter presenter;

    public HomeModulePresenterImpl(Context context, HomeModulePresenter presenter) {
        super(context);
        this.presenter = presenter;
    }

    public void setPresenter(HomeModulePresenter presenter) {
        this.presenter = presenter;
    }


    public void loadYuanwangList(Map<String, String> map) {
        Call<BaseBean<HomeModuleBean>> call = ApiFactory.INSTANCE.getApiService().loadHomeModuleData(map);
        call.enqueue(baseCallBack);
    }


    @Override
    protected void onSuccess(HomeModuleBean commentBean) {
        if (presenter != null)
            presenter.onSuccess(commentBean);
    }

    @Override
    protected void onFail(String msg) {
        if (presenter != null)
            presenter.onFailed(null);
    }
}
