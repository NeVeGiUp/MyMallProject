package com.lgh.havehui.allpackage.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.HotActivityAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/12.
 */
public class HotFragment extends BaseFragment {

    @BindView(R.id.hot_recycleview)
    RecyclerView       mHotRecycleview;
    @BindView(R.id.hot_smartRefresh)
    SmartRefreshLayout mSmartRefreshLayout;

    private HotActivityAdapter mHotActivityAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.hot_fragment;
    }

    @Override
    protected void init() {

        initSmartRefresh();
        initRv();  //初始化recycleView
        initData(); //初始化数据,现为测试数据
    }

    private void initSmartRefresh() {

        //监听事件
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

            }
        });
        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadMoreData();
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
               ;
            }
        });
    }


    private void initRv() {
        //进程的优先级
        /*Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);*/

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mHotRecycleview.setHasFixedSize(true);
        mHotRecycleview.setLayoutManager(manager);

        mHotActivityAdapter = new HotActivityAdapter(getActivity());
        mHotRecycleview.setAdapter(mHotActivityAdapter);
    }


    private void initData() {

        mHotActivityAdapter.setList(getlist(),false);

    }

    private void loadMoreData() {

        mHotActivityAdapter.setList(getlist(),true);

    }


    public List<String> getlist() {
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add("");
        }
        return list;
    }


}
