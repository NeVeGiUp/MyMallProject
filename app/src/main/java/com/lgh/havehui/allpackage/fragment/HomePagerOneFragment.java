package com.lgh.havehui.allpackage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.HomePagerOneAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/27.
 */
public class HomePagerOneFragment extends BaseFragment {
    @BindView(R.id.home_pager_one_rv)
    RecyclerView mHomePagerOneRv;
    private HomePagerOneAdapter mPagerOneAdapter;

    @Override
    protected void init() {
        //获取之前设置的参数
        Bundle arguments = getArguments();
        String code = arguments.getString("status");

        initRv();
        initData();
    }


    private void initRv() {

        //mHomePagerOneRv.setVisibility(View.GONE);     //数据加载成功后设置为可见,失败,状态吗不是200都是不可见

        mPagerOneAdapter = new HomePagerOneAdapter(getActivity());
        mHomePagerOneRv.setHasFixedSize(true);
        mHomePagerOneRv.setFocusableInTouchMode(true);
        mHomePagerOneRv.requestFocus();
        mHomePagerOneRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomePagerOneRv.setAdapter(mPagerOneAdapter);

    }

    private void initData() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_pager_one;
    }

    public static Fragment newInstance(String code) {
        HomePagerOneFragment fragment = new HomePagerOneFragment();
        //Bundle类似于HashMap
        Bundle bundle = new Bundle();
        bundle.putString("status", code);   //根据不同tab切换加载不同的数据
        fragment.setArguments(bundle);//给Fragment设置参数
        return fragment;
    }



}
