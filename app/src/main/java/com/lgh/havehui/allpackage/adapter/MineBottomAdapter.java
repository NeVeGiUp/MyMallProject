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
import com.lgh.havehui.allpackage.bean.AddViewDataBean;
import com.lgh.havehui.allpackage.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/11/8.
 */

public class MineBottomAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public MineBottomAdapter(Context context) {
        this.mContext = context;
        setList(filldata());
    }

    public List<AddViewDataBean> getList() {
        return mList;
    }

    public void setList(List<AddViewDataBean> list) {
        if (list != null && list.size() > 0) {
            this.mList.clear();
            addList(list);
        }
    }

    private void addList(List<AddViewDataBean> list) {
        if (list != null) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    private List<AddViewDataBean> mList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mine_bottom, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        AddViewDataBean addViewDataBean = mList.get(position);

        if (position != 0)
            itemHolder.mItemBottomRightIv.setImageResource(R.color.colorWhite);

        itemHolder.mItemBottomIv.setImageResource(addViewDataBean.getImage());
        itemHolder.mItemBottomTv.setText(addViewDataBean.getName());

        click(itemHolder.mBottomContain, position);

    }

    private void click(LinearLayout bottomContain, final int position) {
        bottomContain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        MyToast.toast(mContext, "item1");
                        break;
                    case 1:
                        MyToast.toast(mContext, "item2");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        break;
                }
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

        @BindView(R.id.item_bottom_right_iv)
        ImageView    mItemBottomRightIv;
        @BindView(R.id.item_bottom_iv)
        ImageView    mItemBottomIv;
        @BindView(R.id.item_bottom_tv)
        TextView     mItemBottomTv;
        @BindView(R.id.item_bottom_cotain)
        LinearLayout mBottomContain;

        public ItemViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    private List<AddViewDataBean> filldata() {
        List<AddViewDataBean> bottomlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AddViewDataBean bean = new AddViewDataBean();
            if (i == 0) {
                bean.setName(mContext.getString(R.string.order_gift));
                bean.setImage(R.mipmap.mine_gift);
            } else if (i == 1) {
                bean.setName(mContext.getString(R.string.coupon_guide));
                bean.setImage(R.mipmap.guide_xxh);
            } else if (i == 2) {
                bean.setName(mContext.getString(R.string.custom));
                bean.setImage(R.mipmap.custom_xxh);
            } else if (i == 3) {
                bean.setName(mContext.getString(R.string.star));
                bean.setImage(R.mipmap.mine_star_xxh);
            } else if (i == 4) {
                bean.setName(mContext.getString(R.string.set_push));
                bean.setImage(R.mipmap.set_push_xxh);
            } else if (i == 5) {
                bean.setName(mContext.getString(R.string.share_friend));
                bean.setImage(R.mipmap.mine_share_xxh);
            } else if (i == 6) {
                bean.setName(mContext.getString(R.string.clear_cache));
                bean.setImage(R.mipmap.clear_xxh);
            } else if (i == 7) {
                bean.setName(mContext.getString(R.string.remove_bind));
                bean.setImage(R.mipmap.tao_xxh);
            } else if (i == 8) {
                bean.setName(mContext.getString(R.string.borrow_money));
                bean.setImage(R.mipmap.money_xxh);
            } else if (i == 9) {
                bean.setName(mContext.getString(R.string.logoff));
                bean.setImage(R.mipmap.logoff_xxh);
            }

            bottomlist.add(bean);
        }

        return bottomlist;
    }

    public void goTo(Class<?> to) {
        Intent in = new Intent();
        in.setClass(mContext, to);
        mContext.startActivity(in);

    }

}
