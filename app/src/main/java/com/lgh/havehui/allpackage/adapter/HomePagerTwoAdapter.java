package com.lgh.havehui.allpackage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diycoder.library.adapter.BaseAdapter;
import com.lgh.havehui.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/7/28.
 */

public class HomePagerTwoAdapter extends BaseAdapter<String, HomePagerTwoAdapter.ViewHolder> {


    private Context mContext;

    public HomePagerTwoAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_pager_two, parent, false));
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, final int position) {
        String itemData = getItemData(position);

       /* holder.mContainLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.toast(mContext, position + 1 + "");
            }
        });*/

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_pager_two_iv)
        ImageView      mHomePagerTwoIv;
        @BindView(R.id.home_pager_two_descrip_tv)
        TextView       mHomePagerTwoDescripTv;
        @BindView(R.id.home_pager_two_price_tv)
        TextView       mHomePagerTwoPriceTv;
        @BindView(R.id.home_pager_two_soldout_tv)
        TextView       mHomePagerTwoSoldoutTv;
        @BindView(R.id.like_contain)
        RelativeLayout mLikeContain;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
