package com.lgh.havehui.allpackage.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.Toast;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.HomePagerFragmentAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;
import com.lgh.havehui.allpackage.bean.HomeModuleBean;
import com.lgh.havehui.allpackage.presenter.HomeModulePresenter;
import com.lgh.havehui.allpackage.presenterimpl.HomeModulePresenterImpl;
import com.lgh.havehui.allpackage.widget.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/12.
 */
public class HomeFragment extends BaseFragment implements HomeModulePresenter {

    private static final String[]     CHANNELS  = new String[]{"主页", "近一周最热", "近一个月最热", "一个月最热", "视频"};
    private              List<String> mDataList = Arrays.asList(CHANNELS);
    private List<Fragment> mFragments;

    @BindView(R.id.home_search_input_et)
    EditText       mHomeSearchInputEt;
    @BindView(R.id.magic_indicator)
    MagicIndicator mMagicIndicator;
    @BindView(R.id.home_view_pager)
    ViewPager      mHomeViewPager;

    private HomePagerFragmentAdapter mPagerFragmentAdapter;
    private HomeModulePresenterImpl mPresenterImpl;


    @Override
    protected void init() {
        initFragment();
        initMagicIndicator();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("menuType","1");
        mPresenterImpl = new HomeModulePresenterImpl(getActivity(),this);
        mPresenterImpl.loadYuanwangList(map);
    }

    private void initFragment() {
        //构造适配器
        mFragments = new ArrayList<>();
        mFragments.add(new HomePagerOneFragment());
        mFragments.add(new HomePagerTwoFragment());
    }

    private void initMagicIndicator() {

        mPagerFragmentAdapter = new HomePagerFragmentAdapter(getChildFragmentManager(), mDataList, mFragments);
        mMagicIndicator.setEnabled(true);
        mHomeViewPager.setAdapter(mPagerFragmentAdapter);

        mMagicIndicator.setBackgroundColor(Color.parseColor("#FFFFFF"));
        CommonNavigator commonNavigator7 = new CommonNavigator(getActivity());
        //commonNavigator7.isAdjustMode();                //title平分屏幕
        commonNavigator7.setSkimOver(true);
        int paddingleft = UIUtil.getScreenWidth(getActivity()) / 23;
        int paddingright = UIUtil.getScreenWidth(getActivity()) / 12;
        commonNavigator7.setRightPadding(paddingright);
        commonNavigator7.setLeftPadding(paddingleft);
        commonNavigator7.setScrollPivotX(0.65f); // 滚动中心点 0.0f - 1.0f
        commonNavigator7.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                //title文字,滑动动画效果,缩进
                ScaleTransitionPagerTitleView pagerTitleView = new ScaleTransitionPagerTitleView(context);

                pagerTitleView.setText(mDataList.get(index));
                pagerTitleView.setTextSize(13.5f);
                pagerTitleView.setNormalColor(Color.parseColor("#999999"));
                pagerTitleView.setSelectedColor(Color.parseColor("#F83B2B"));
                pagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mHomeViewPager.setCurrentItem(index);
                    }
                });
                return pagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                //indicator样式
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 3));
                indicator.setLineWidth(UIUtil.dip2px(context, 25));
                indicator.setRoundRadius(UIUtil.dip2px(context, 2));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(Color.parseColor("#F74A46"));
                return indicator;
            }
        });

        mMagicIndicator.setNavigator(commonNavigator7);
        //绑定viewpager
        ViewPagerHelper.bind(mMagicIndicator, mHomeViewPager);


    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }


    @OnClick({R.id.home_shopping_cart_iv, R.id.home_cate_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_shopping_cart_iv:
                Toast.makeText(getActivity(), "去购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_cate_iv:
                mMagicIndicator.setEnabled(false);
                Toast.makeText(getActivity(), "mImageView被点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //数据加载成功
    @Override
    public void onSuccess(Object data) {
        HomeModuleBean bean = (HomeModuleBean) data;
        if (bean!=null) {

        }

    }


    //数据加载失败
    @Override
    public void onFailed(String msg) {

    }


    @Override
    public void onDestroy() {

        if (mPresenterImpl != null) {
            mPresenterImpl.setPresenter(null);
        }
        super.onDestroy();
    }
}
