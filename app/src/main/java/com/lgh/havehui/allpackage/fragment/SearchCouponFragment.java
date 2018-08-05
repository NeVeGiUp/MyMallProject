package com.lgh.havehui.allpackage.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.diycoder.library.listener.ScrollListener;
import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.SearchLikeAdapter;
import com.lgh.havehui.allpackage.adapter.SearchShopCateAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;
import com.lgh.havehui.allpackage.widget.CustomGridLayoutManager;
import com.lgh.havehui.allpackage.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/12.
 */
public class SearchCouponFragment extends BaseFragment {

    @BindView(R.id.search_use_direction_tv)
    TextView     mSearchUseDirectionTv;
    @BindView(R.id.search_coupon_count_tv)
    TextView     mSearchCouponCountTv;
    @BindView(R.id.search_input_et)
    EditText     mSearchInputEt;
    @BindView(R.id.search_cate_rv)
    RecyclerView mSearchCateRv;
    @BindView(R.id.search_like_rv)
    RecyclerView mSearchLikeRv;


    private MyScrollListener  scrollListtener;
    private SearchLikeAdapter mLikeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.search_coupon_fragment;
    }

    @Override
    protected void init() {

        initCateRv();
        initLikeRv();
        initData();

    }


    private void initCateRv() {
        mSearchCateRv.setHasFixedSize(true);
        CustomGridLayoutManager manager = new CustomGridLayoutManager(getActivity(), 4);
        //GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        manager.setScrollEnabled(false);
        mSearchCateRv.setLayoutManager(manager);

        SearchShopCateAdapter cateAdapter = new SearchShopCateAdapter(getActivity());
        cateAdapter.setList(getlist());
        mSearchCateRv.setAdapter(cateAdapter);


    }

    private List<String> getlist() {

        List list = new ArrayList();
        for (int i = 0; i < 8; i++) {
            list.add("");
        }
        return list;
    }

    private void initLikeRv() {
        CustomGridLayoutManager manager = new CustomGridLayoutManager(getActivity(), 2);
        //GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        mSearchLikeRv.setHasFixedSize(true);
        manager.setScrollEnabled(false);
        mSearchLikeRv.setLayoutManager(manager);

        //设置item间隔
        int leftspace = getResources().getDimensionPixelSize(R.dimen.dp2);
        int bottomspace = getResources().getDimensionPixelSize(R.dimen.dp4);
        mSearchLikeRv.addItemDecoration(new SpacesItemDecoration(leftspace, bottomspace));

        mLikeAdapter = new SearchLikeAdapter(getActivity());
        mSearchLikeRv.setAdapter(mLikeAdapter);
        mSearchLikeRv.addOnScrollListener(scrollListtener = new MyScrollListener(manager));

    }

    /**
     * 猜你喜欢的滑动监听加载更多
     */
    class MyScrollListener extends ScrollListener {
        public MyScrollListener(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }


        @Override
        public void onLoadMore() {
            scrollListtener.setLoadMore(true);
            mLikeAdapter.setHasMoreData(true);
            initData();
           /* if (if_more == 1) {
                min_id = mPivChildAdapter.getItemData(mPivChildAdapter.getDataList().size() - 1).getId();
                initData();
            } else {
                scrollListtener.setLoadMore(false);
                mPivChildAdapter.setHasMoreData(false);
            }*/
        }
    }


    private void initData() {

        //测试用
        mLikeAdapter.setDataList(getlist());
        mLikeAdapter.setHasMoreData(false);

    }


}
