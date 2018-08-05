package com.lgh.havehui.allpackage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/11/8.
 */

public class SearchShopCateAdapter extends RecyclerView.Adapter {


    private Context mContext;

    public SearchShopCateAdapter(Context context) {
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
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_cate, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        String s = mList.get(position);

        itemHolder.mItemCateCotainLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.toast(mContext, position + 1 + "");
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        else
            return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cate_iv)
        ImageView    mCateIv;
        @BindView(R.id.cate_tv)
        TextView     mCateTv;
        @BindView(R.id.item_cate_cotain_ll)
        LinearLayout mItemCateCotainLl;

        public ItemViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public void goTo(Class<?> to) {
        Intent in = new Intent();
        in.setClass(mContext, to);
        mContext.startActivity(in);

    }

}
