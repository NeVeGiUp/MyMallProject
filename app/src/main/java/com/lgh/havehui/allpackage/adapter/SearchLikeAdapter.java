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
import com.lgh.havehui.allpackage.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/7/28.
 */

public class SearchLikeAdapter extends BaseAdapter<String, SearchLikeAdapter.ViewHolder> {

    private Context mContext;

    public SearchLikeAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_search_like, parent, false));
    }

    @Override
    public void onBindItemViewHolder(ViewHolder holder, final int position) {
        String itemData = getItemData(position);

        holder.mContainLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.toast(mContext, position + 1 + "");
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.like_iv)
        ImageView      mLikeIv;
        @BindView(R.id.like_descrip_tv)
        TextView       mLikeDescripTv;
        @BindView(R.id.like_price_tv)
        TextView       mLikePriceTv;
        @BindView(R.id.like_soldout_tv)
        TextView       mLikeSoldoutTv;
        @BindView(R.id.like_contain)
        RelativeLayout mContainLl;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
