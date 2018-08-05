package com.lgh.havehui.allpackage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lgh.havehui.allpackage.fragment.HomePagerOneFragment;
import com.lgh.havehui.allpackage.fragment.HomePagerTwoFragment;

import java.util.List;


public class HomePagerFragmentAdapter extends FragmentStatePagerAdapter {

    private List<String> mDataList;
    private List<Fragment> mFragmentList = null;


    public HomePagerFragmentAdapter(FragmentManager fm, List<String> list, List<Fragment> fragmentList) {
        super(fm);
        if (list != null && list.size() > 0) {
            mDataList = list;
        }

        if (fragmentList != null && fragmentList.size() > 0) {
            mFragmentList = fragmentList;
        }
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
       /* if (position < mFragmentList.size()) {
            fragment = mFragmentList.get(position);
        } else {
            fragment = mFragmentList.get(0);
        }*/
        if (position == 0) {
            //fragment = mFragmentList.get(0);
            fragment = HomePagerOneFragment.newInstance("");
        } else {
            fragment = HomePagerTwoFragment.newInstance("");
            //fragment = mFragmentList.get(1);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        //return mFragmentList.size();
        return 5;  //测试先写死数量
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }

    public void setBoldCallBack(boldCallBack boldCallBack) {
        mBoldCallBack = boldCallBack;
    }

    private boldCallBack mBoldCallBack;   //备用接口回调,暂无用


    public interface boldCallBack {
        void boldcallback(int position);
    }
}
