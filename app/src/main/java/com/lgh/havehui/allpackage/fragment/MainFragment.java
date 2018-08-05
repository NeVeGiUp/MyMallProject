package com.lgh.havehui.allpackage.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lgh.havehui.R;
import com.lgh.havehui.allpackage.base.BaseFragment;

import butterknife.BindView;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/11.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.main_bottom_layout_ll)
    LinearLayout mainBottomLayoutLl;


    @Override
    protected void init() {
        initBottom();
        changeUi(0);

    }

    private void initBottom() {
        int childCount = mainBottomLayoutLl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = mainBottomLayoutLl.getChildAt(i);
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //根据孩子获取所在位置索引
                    int index = mainBottomLayoutLl.indexOfChild(child);
                    changeUi(index);
                }
            });
        }
    }

    private void changeUi(int index) {

        hideFragment();
        showFragment(index);
        int childCount = mainBottomLayoutLl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = mainBottomLayoutLl.getChildAt(i);
            if (index == i) {
                setEnabled(child, false);
            } else {
                setEnabled(child, true);
            }
        }


    }

    private void setEnabled(View child, boolean enable) {
        child.setEnabled(enable);
        //如果是viewGroup的话就递归排除
        if (child instanceof ViewGroup) {
            int childCount = ((ViewGroup) child).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View item = ((ViewGroup) child).getChildAt(i);
                item.setEnabled(enable);
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    private void hideFragment() {
        FragmentManager fragmentManager = getChildFragmentManager();
        Fragment one = fragmentManager.findFragmentByTag("one");
        Fragment two = fragmentManager.findFragmentByTag("two");
        Fragment three = fragmentManager.findFragmentByTag("three");
        Fragment four = fragmentManager.findFragmentByTag("four");


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (one != null) {
            fragmentTransaction.hide(one);
        }
        if (two != null) {
            fragmentTransaction.hide(two);
        }
        if (three != null) {
            fragmentTransaction.hide(three);
        }
        if (four != null) {
            fragmentTransaction.hide(four);
        }

        fragmentTransaction.commitAllowingStateLoss();
    }

    private void showFragment(int position) {
        FragmentManager fragmentManager = getChildFragmentManager();
        Fragment one = fragmentManager.findFragmentByTag("one");
        Fragment two = fragmentManager.findFragmentByTag("two");
        Fragment three = fragmentManager.findFragmentByTag("three");
        Fragment four = fragmentManager.findFragmentByTag("four");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (position == 0) {
            if (one != null)
                fragmentTransaction.show(one);
            else
                fragmentTransaction.add(R.id.main_fragment_container, new HomeFragment(), "one");
        } else if (position == 1) {
            if (two != null)
                fragmentTransaction.show(two);
            else
                fragmentTransaction.add(R.id.main_fragment_container, new HotFragment(), "two");
        } else if (position == 2) {
            if (three != null)
                fragmentTransaction.show(three);
            else
                fragmentTransaction.add(R.id.main_fragment_container, new SearchCouponFragment(), "three");
        } else if (position == 3) {
            if (four != null)
                fragmentTransaction.show(four);
            else {
                fragmentTransaction.add(R.id.main_fragment_container, new MineFragment(), "four");
            }
        }

        fragmentTransaction.commitAllowingStateLoss();


    }

}
