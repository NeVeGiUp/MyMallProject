package com.lgh.havehui.allpackage.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.adapter.MineBottomAdapter;
import com.lgh.havehui.allpackage.base.BaseFragment;
import com.lgh.havehui.allpackage.utils.MyToast;
import com.lgh.havehui.allpackage.widget.CircleImageView;
import com.lgh.havehui.allpackage.widget.CustomGridLayoutManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/12.
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.mine_sculpture)
    CircleImageView mMineSculpture;
    @BindView(R.id.mine_phone)
    TextView        mMinePhone;
    @BindView(R.id.mine_save)
    TextView        mMineSave;
    @BindView(R.id.mineorder_contain_ll)
    LinearLayout    mMineorderContainLl;
    @BindView(R.id.mine_bootom_rv)
    RecyclerView    mMineBootomRv;

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void init() {

        addOrderChildView();
        addBottomChildView();

    }

    //我的订单添加子view
    private void addOrderChildView() {

        mMineorderContainLl.removeAllViews();
        for (int i = 0; i < 4; i++) {
            //addview操作
            View contentchild = getActivity().getLayoutInflater().inflate(R.layout.item_mine_order, null);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f);
            contentchild.setLayoutParams(lp);

            ImageView content_iv = (ImageView) contentchild.findViewById(R.id.item_order_iv);
            TextView content_tv = (TextView) contentchild.findViewById(R.id.item_order_tv);

            if (i == 0) {
                content_tv.setText(R.string.mine_order);
                content_iv.setImageResource(R.mipmap.mine_order_xxh);
            } else if (i == 1) {
                content_tv.setText(R.string.had_coupon);
                content_iv.setImageResource(R.mipmap.had_coupon_xxh);
            } else if (i == 2) {
                content_tv.setText(R.string.mine_collect);
                content_iv.setImageResource(R.mipmap.mine_collect_xxh);
            } else if (i == 3) {
                content_tv.setText(R.string.browsing_history);
                content_iv.setImageResource(R.mipmap.browsing_history_xxh);
            }

            mMineorderContainLl.addView(contentchild);

            orderclick(contentchild, i);
        }


    }

    //我的订单添加子view 点击事件
    private void orderclick(View contentchild, final int i) {
        contentchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0:
                        MyToast.toast(getActivity(), "我的订单");
                        break;
                    case 1:
                        MyToast.toast(getActivity(), "已领优惠劵");
                        break;
                    case 2:
                        MyToast.toast(getActivity(), "我的收藏");
                        break;
                    case 3:
                        MyToast.toast(getActivity(), "浏览足迹");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    //底部栏添加子view
    private void addBottomChildView() {

        mMineBootomRv.setHasFixedSize(true);
        mMineBootomRv.setFocusableInTouchMode(false);  //去除焦点,recycleView嵌套recycleView时会自动滚动
        mMineBootomRv.requestFocus();

        CustomGridLayoutManager linearLayoutManager = new CustomGridLayoutManager(getActivity(),4);
        linearLayoutManager.setScrollEnabled(false);
        mMineBootomRv.setLayoutManager(linearLayoutManager);

        MineBottomAdapter adapter = new MineBottomAdapter(getActivity());
        mMineBootomRv.setAdapter(adapter);
    }


    @OnClick(R.id.mine_setting_iv)
    public void onClick() {
        //我的设置按钮
        MyToast.toast(getActivity(), "去设置");
    }
}
