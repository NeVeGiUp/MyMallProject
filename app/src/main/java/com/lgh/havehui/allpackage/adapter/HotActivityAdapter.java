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
 * Created by MyPC on 2017/7/28.
 */

public class HotActivityAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public HotActivityAdapter(Context context) {
        this.mContext = context;
    }

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list,boolean isloadmore) {
        if (list != null && list.size() > 0) {      //双重判断
            if (!isloadmore) {
            this.mList.clear();
            }
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
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_hot_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        else
            return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_hot_iv)
        ImageView    mItemHotIv;
        @BindView(R.id.item_hot_go_iv)
        ImageView mItemHotGoIv;
        @BindView(R.id.item_hot_descrip)
        TextView     mItemHotDescrip;
        @BindView(R.id.item_hot_days)
        TextView  mItemHotDays;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
