package com.lgh.havehui.allpackage.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.lgh.havehui.allpackage.application.CouponProductApplication;
import com.lgh.havehui.allpackage.utils.LoadDialog;
import com.lgh.havehui.allpackage.utils.LoadNoTvDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/9/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayout noDataLl, noNetWorkLl, progressBarLl;
    private Unbinder   bind;
    private LoadDialog loadDialog;
    private LoadNoTvDialog mNoTvDialog;
   // private TextView   title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((CouponProductApplication) this.getApplication()).getActivityManager()
                .pushActivity(this); //
        // 设置不能横屏，防止生命周期的改变
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        this.setContentView(getLayoutId());
        bind = ButterKnife.bind(this);


    /*    title = (TextView) findViewById(R.id.title);
        if (title != null)
            title.setText(getATitle());*/

       /* ImageView backIv = (ImageView) findViewById(R.id.back_iv);
        if (backIv != null)
            backIv.setOnClickListener(this);*/

        //无数据无网络显示
        //noDataLl = (LinearLayout) findViewById(R.id.nodata_layout);
        //noNetWorkLl = (LinearLayout) findViewById(R.id.network_layout);
        //progressBarLl = (LinearLayout) findViewById(R.id.progressBar_layout);

        init();
    }


    protected abstract void init();

    protected abstract int getLayoutId();

    //protected abstract String getATitle();


    @Override
    public void onClick(View view) {
       /* switch (view.getId()) {
            case R.id.back_iv:
                if (DensityUtil.isSoftShowing(this)) {
                    DensityUtil.showOrSoft(this);
                }
                finish();
                break;
        }*/
    }
/*
    public void setBTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            if (title.length() > 14) {
                this.title.setTextSize(14);
            } else if (title.length() > 25) {
                this.title.setTextSize(12);
            }
            this.title.setText(title);
        }
    }*/

    //有进度,字体的dialog
    public void show(String text) {
        if (loadDialog == null)
            loadDialog = new LoadDialog(this, text);

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
            mNoTvDialog = new LoadNoTvDialog(this);
        mNoTvDialog.show();
    }

    public void dismissNoTitle() {
        if (mNoTvDialog != null)
            mNoTvDialog.dismiss();
    }


    @Override
    protected void onDestroy() {
        bind.unbind();
        dismiss();
        super.onDestroy();
        ((CouponProductApplication) this.getApplication()).getActivityManager().popActivity(this);
    }


    public void goTo(Class<?> to, Bundle bundle) {
        Intent it = new Intent(this, to);
        it.putExtras(bundle);
        startActivity(it);
    }


    public void goTo(Class<?> to) {
        Intent it = new Intent(this, to);
        startActivity(it);
    }

    public void goToForResult(Class<?> to, int requestCode) {
        Intent it = new Intent(this, to);
        startActivityForResult(it, requestCode);
    }

    public void goToForResult(Class<?> to, Bundle bundle, int requestCode) {
        Intent it = new Intent(this, to);
        it.putExtras(bundle);
        startActivityForResult(it, requestCode);

    }

}
