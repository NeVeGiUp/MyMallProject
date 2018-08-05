package com.lgh.havehui.allpackage.base;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by ${lhh} on 2017/10/21.
 * 修改glide加载图片为 Bitmap格式ARGB_8888，Glide默认Bitmap格式为RGB_565
 */

public class GlideConfiguration implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
    }
    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
