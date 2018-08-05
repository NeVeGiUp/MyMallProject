package com.lgh.havehui.allpackage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.diycoder.library.listener.ScrollListener;
import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.HomePagerTwoAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;
import com.lgh.havehui.allpackage.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/27.
 */
public class HomePagerTwoFragment extends BaseFragment {
    @BindView(R.id.home_pager2_rv)
    RecyclerView mHomePager2Rv;


    private MyScrollListener scrollListtener;
    private HomePagerTwoAdapter mPagerTwoAdapter;

    @Override
    protected void init() {

        //获取之前设置的参数
        Bundle arguments = getArguments();
        String code = arguments.getString("status");

        initRv();
        initData();

    }

    private void initData() {
        mPagerTwoAdapter.setDataList(getlist());
    }

    private List<String> getlist() {

        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("");
        }
        return list;
    }

    private void initRv() {

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        mHomePager2Rv.setHasFixedSize(true);
        mHomePager2Rv.setLayoutManager(manager);

        //设置item间隔
        int leftspace = getResources().getDimensionPixelSize(R.dimen.dp2);
        int bottomspace = getResources().getDimensionPixelSize(R.dimen.dp5);
        mHomePager2Rv.addItemDecoration(new SpacesItemDecoration(leftspace, bottomspace));

        mPagerTwoAdapter = new HomePagerTwoAdapter(getActivity());
        mHomePager2Rv.setAdapter(mPagerTwoAdapter);
        mHomePager2Rv.addOnScrollListener(scrollListtener = new MyScrollListener(manager));
    }


    class MyScrollListener extends ScrollListener {
        public MyScrollListener(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }


        @Override
        public void onLoadMore() {
            scrollListtener.setLoadMore(true);
            mPagerTwoAdapter.setHasMoreData(true);

           /* if (if_more == 1) {
                min_id = mPivChildAdapter.getItemData(mPivChildAdapter.getDataList().size() - 1).getId();
                initData();
            } else {
                scrollListtener.setLoadMore(false);
                mPivChildAdapter.setHasMoreData(false);
            }*/
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_pager_two;
    }


    public static Fragment newInstance(String code) {
        HomePagerTwoFragment fragment = new HomePagerTwoFragment();
        //Bundle类似于HashMap
        Bundle bundle = new Bundle();
        bundle.putString("status", code);   //根据不同tab切换加载不同的数据
        fragment.setArguments(bundle);//给Fragment设置参数
        return fragment;
    }


}
