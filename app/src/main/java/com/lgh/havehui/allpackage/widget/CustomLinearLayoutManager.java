package com.lgh.havehui.allpackage.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;


//RecycleView 不能滑动，消除阴影的布局管理器,LinearLayoutManager也一样
public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }


    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}