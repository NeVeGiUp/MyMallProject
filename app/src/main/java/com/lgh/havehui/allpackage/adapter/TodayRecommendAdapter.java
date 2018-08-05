package com.lgh.havehui.allpackage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgh.havehui.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/11/8.
 */

public class TodayRecommendAdapter extends RecyclerView.Adapter {


    private Context mContext;

    public TodayRecommendAdapter(Context context) {
        this.mContext = context;
    }

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.mList.clear();
            addList(list);
        }
    }

    private void addList(List<String> list) {
        if (list != null) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    private List<String> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_today_recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        String s = mList.get(position);


    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        else
            return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.today_recommend_iv)
        ImageView mTodayRecommendIv;
        @BindView(R.id.today_recommend_descrip_tv)
        TextView  mTodayRecommendDescripTv;
        @BindView(R.id.today_recommend_taobao_price_tv)
        TextView  mTodayRecommendTaobaoPriceTv;
        @BindView(R.id.today_recommend_coupon_price_tv)
        TextView  mTodayRecommendCouponPriceTv;
        @BindView(R.id.today_recommend_sold_count)
        TextView  mTodayRecommendSoldCount;
        @BindView(R.id.today_recommend_coupon_yuan_tv)
        TextView  mTodayRecommendCouponYuanTv;

        public ItemViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }
}
