package com.lgh.havehui.allpackage.base;

import android.support.v7.widget.RecyclerView;

import com.lgh.havehui.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView; /**
 * Created by Leon on 2017/1/16.
 */

/**
 * 将相同的功能 布局 和属性抽取出来，不同实现交给子类实现
 * <p>
 * 抽取公共的布局 SwipeRefreshLayout和RecyclerView
 * 公共业务逻辑： 初始化时加载数据 下拉刷新 加载更多数据
 * <p>
 * 不同点：每个界面的adapter不一样
 * 网络数据不一样， 不同presenter的实现
 */
public class BaseListFragment extends BaseFragment implements BasePresenter {


    @BindView(R.id.base_list_recycleview)
    RecyclerView       mBaseListRecycleview;
    @BindView(R.id.base_list_smartrefresh)
    SmartRefreshLayout mBaseListSmartrefresh;

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.base_list_fragment;
    }

    @Override
    public void onSuccess(Object data) {

    }

    @Override
    public void onFailed(String msg) {

    }


}
