package com.lgh.havehui.allpackage.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.utils.DensityUtil;
import com.lgh.havehui.allpackage.utils.MyToast;
import com.lgh.havehui.allpackage.widget.GlideRoundTransform;
import com.lgh.havehui.allpackage.widget.SpacesItemDecoration;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2018/1/2.
 */

public class HomePagerOneAdapter extends RecyclerView.Adapter {


    private static final int type_top             = 0;//顶部
    private static final int type_hot_recommend   = 1;//热门推荐
    private static final int type_brand           = 2;//品牌优选
    private static final int type_today_recommend = 3;//今日推荐


    private Context        context;
    private LayoutInflater inflater;

    public HomePagerOneAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == type_top) {
            TopViewHolder viewHolder = new TopViewHolder(inflater.inflate(R.layout.pager_one_type_banner, parent, false));
            LinearLayout.LayoutParams layoutParams
                    = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.height = DensityUtil.getScreenWidth(context) * 380 / 750;
            //viewHolder.mBanner.setLayoutParams(layoutParams);
            return viewHolder;
        } else if (viewType == type_hot_recommend) {
            return new HotRecommendHolder(inflater.inflate(R.layout.pager_one_type_hotrecommend, parent, false));
        } else if (viewType == type_brand) {
            return new BrandViewHolder(inflater.inflate(R.layout.pager_one_type_brand, parent, false));
        } else if (viewType == type_today_recommend) {
            return new JrtjViewHolder(inflater.inflate(R.layout.pager_one_type_todayrecommend, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        if (viewType == type_top) {
            TopViewHolder topHolder = (TopViewHolder) holder;
            bindTop(topHolder);
        } else if (viewType == type_hot_recommend) {
            HotRecommendHolder backHolder = (HotRecommendHolder) holder;
            bindHotRecommend(backHolder);
        } else if (viewType == type_brand) {
            BrandViewHolder newholder = (BrandViewHolder) holder;
            bindBrand(newholder);
        } else if (viewType == type_today_recommend) {
            JrtjViewHolder mustholder = (JrtjViewHolder) holder;
            bindJrtj(mustholder);
        }
    }


    //头部数据,banner以及cate
    private void bindTop(TopViewHolder topHolder) {
        bindbanner(topHolder);
        bindcate(topHolder);
    }

    //轮播图
    private void bindbanner(TopViewHolder topHolder) {

        topHolder.mHomePageroneBanner.setDelayedTime(5000); //切换时间间隔
        topHolder.mHomePageroneBanner.setDuration(1000);   //设置ViewPager（Banner）切换速度
        topHolder.mHomePageroneBanner.setIndicatorVisible(false);   //是否显示指示器
        //mBanner.setIndicatorRes(R.drawable.indicator_default,R.drawable.indicator_selector);   //设置指示器资源
        //mBanner.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);  //设置指示器显示位置

        //ViewPager viewPager = mBanner.getViewPager();  // 获取ViewPager


        topHolder.mHomePageroneBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {  //点击事件
            @Override
            public void onPageClick(View view, int position) {
                MyToast.toast(context, "click page:" + position);
            }
        });


        topHolder.mHomePageroneBanner.setPages(getList(), new MZHolderCreator<BannerViewHolder>() {     // 设置数据
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        topHolder.mHomePageroneBanner.start();

    }

    //假数据
    private String baseurl = "https://images.quanchepin.com/data/files/mall/slide/";

    private List getList() {
        List<String> list = new ArrayList<>();
        list.add(baseurl + "201711291541586301.png");
        list.add(baseurl + "201711291541586301.png");
        list.add(baseurl + "201711291541586301.png");
        list.add(baseurl + "201711291541586301.png");
        list.add(baseurl + "201711291541586301.png");
        return list;
    }

    //分类
    private void bindcate(TopViewHolder topHolder) {

        topHolder.mHomePageroneCateLl.removeAllViews();
        for (int i = 0; i < 4; i++) {
            //addview操作
            View contentchild = inflater.inflate(R.layout.item_home_cate, null);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            contentchild.setLayoutParams(lp);

            ImageView content_iv = (ImageView) contentchild.findViewById(R.id.item_home_cate_iv);
            TextView content_tv = (TextView) contentchild.findViewById(R.id.item_home_cate_tv);

            if (i == 0) {
                content_tv.setText(R.string.inexpensive_nine);
                content_iv.setImageResource(R.mipmap.home_cate_nine);
            } else if (i == 1) {
                content_tv.setText(R.string.inexpensive_twenty);
                content_iv.setImageResource(R.mipmap.home_cate_twenty);
            } else if (i == 2) {
                content_tv.setText(R.string.sale_sort);
                content_iv.setImageResource(R.mipmap.home_cate_sale);
            } else if (i == 3) {
                content_tv.setText(R.string.common_question);
                content_iv.setImageResource(R.mipmap.home_cate_question);
            }

            topHolder.mHomePageroneCateLl.addView(contentchild);

            cateclick(contentchild, i);
        }

    }

    //轮播图下分类点击
    private void cateclick(View contentchild, final int i) {
        contentchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.toast(context, "点击条目  " + i + 1);
            }
        });

    }


    //热门推荐
    private void bindHotRecommend(HotRecommendHolder backHolder) {

        backHolder.mHomePageroneHotrecommendRv.setHasFixedSize(true);
        backHolder.mHomePageroneHotrecommendRv.setFocusableInTouchMode(true);  //去除焦点,recycleView嵌套recycleView时会自动滚动
        backHolder.mHomePageroneHotrecommendRv.requestFocus();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        backHolder.mHomePageroneHotrecommendRv.setLayoutManager(mLayoutManager);

        HotRecommendAdapter hotRecommendAdapter = new HotRecommendAdapter(context);
        hotRecommendAdapter.setList(getList());
        backHolder.mHomePageroneHotrecommendRv.setAdapter(hotRecommendAdapter);

    }

    //品牌优选等
    private void bindBrand(BrandViewHolder newholder) {

    }

    //今日推荐
    private void bindJrtj(JrtjViewHolder mustholder) {

        mustholder.mJrtjRecycleview.setHasFixedSize(true);
        mustholder.mJrtjRecycleview.setFocusableInTouchMode(true);  //去除焦点,recycleView嵌套recycleView时会自动滚动
        mustholder.mJrtjRecycleview.requestFocus();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        mustholder.mJrtjRecycleview.setLayoutManager(mLayoutManager);

        TodayRecommendAdapter todayRecommendAdapter = new TodayRecommendAdapter(context);
        todayRecommendAdapter.setList(getList());
        mustholder.mJrtjRecycleview.setAdapter(todayRecommendAdapter);

    }


    @Override
    public int getItemCount() {
        return 4;
    }


    /**
     * 根据postition返回item的类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return type_top;
        } else if (position == 1) {
            return type_hot_recommend;
        } else if (position == 2) {
            return type_brand;
        } else if (position == 3) {
            return type_today_recommend;
        }
        return 0;
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_pagerone_banner)
        MZBannerView mHomePageroneBanner;
        @BindView(R.id.home_pagerone_cate_ll)
        LinearLayout mHomePageroneCateLl;

        public TopViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String data) {
            // 数据绑定
            Glide.with(context)
                    .load(data)
                    .transform(new CenterCrop(context), new GlideRoundTransform(context))   //图片加载圆角
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .placeholder(R.color.app_bg)
                    .into(mImageView);

        }
    }

    public class HotRecommendHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.check_more_tv)
        TextView     mCheckMoreTv;
        @BindView(R.id.home_pagerone_hotrecommend_rv)
        RecyclerView mHomePageroneHotrecommendRv;

        public HotRecommendHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
            //RecycleView 增加边距
            int leftRight = DensityUtil.dip2px(context, 7);   //设置左右边距
            int topBottom = DensityUtil.dip2px(context, 0);     //设置上下边距
            mHomePageroneHotrecommendRv.addItemDecoration(new SpacesItemDecoration(leftRight, topBottom));  //该方法不可放在onBindViewHolder(),每次刷新都会调用,会产生边距不断倍数增大
        }
    }

    public class BrandViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.left_iv)
        ImageView mLeftIv;
        @BindView(R.id.left_go_iv)
        ImageView mLeftGoIv;
        @BindView(R.id.right_top_iv)
        ImageView mRightTopIv;
        @BindView(R.id.right_bottom_iv1)
        ImageView mRightBottomIv1;
        @BindView(R.id.right_bottom_iv2)
        ImageView mRightBottomIv2;

        public BrandViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }


    public class JrtjViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.jrtj_recycleview)
        RecyclerView mJrtjRecycleview;

        public JrtjViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

}
