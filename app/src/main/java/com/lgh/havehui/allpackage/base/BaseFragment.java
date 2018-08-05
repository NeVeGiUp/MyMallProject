package com.lgh.havehui.allpackage.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lgh.havehui.allpackage.utils.LoadDialog;
import com.lgh.havehui.allpackage.utils.LoadNoTvDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder   unbinder;
    private LoadDialog loadDialog;
    private LoadNoTvDialog mNoTvDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        init();
        return view;
    }

    protected abstract void init();


    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        dismiss();
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
    }

    //有进度,字体的dialog
    public void show(String text) {
        if (loadDialog == null)
            loadDialog = new LoadDialog(getActivity(), text);

        if (!TextUtils.isEmpty(text))
            loadDialog.setText(text);
        loadDialog.show();
    }


    public void dismiss() {
        if (loadDialog != null)
            loadDialog.dismiss();
    }


    //只有进度的dialog
    public void showNoTitle() {
        if (mNoTvDialog == null)
            mNoTvDialog = new LoadNoTvDialog(getActivity());
        mNoTvDialog.show();
    }

    public void dismissNoTitle() {
        if (mNoTvDialog != null)
            mNoTvDialog.dismiss();
    }


    public void goTo(Class<?> to, Bundle bundle) {
        Intent it = new Intent(getActivity(), to);
        it.putExtras(bundle);
        startActivity(it);
    }


    public void goTo(Class<?> to) {
        Intent it = new Intent(getActivity(), to);
        startActivity(it);
    }

    public void goToForResult(Class<?> to, int requestCode) {
        Intent it = new Intent(getActivity(), to);
        startActivityForResult(it, requestCode);
    }

    public void goToForResult(Class<?> to, Bundle bundle, int requestCode) {
        Intent it = new Intent(getActivity(), to);
        it.putExtras(bundle);
        startActivityForResult(it, requestCode);
    }

    //获取屏幕高度
    public int getStatusHeight() {
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }


}
