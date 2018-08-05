package com.lgh.havehui.allpackage.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {

    public static final String USER_NICKNAME  = "nickName";
    public static final String USER_AUTOGRAPH = "autoGraph";
    public static final String USER_TOUXIANG  = "touxiang";
    public static final String CITY           ="city";
    public static final String TOKEN          = "token";
    public static final String USER_PSW       = "password";
    public static final String TOKEN_EXPIRED  = "token_expired";
    public static final String QUICK_PHONE    = "quick_phone";
    public static final String COUPONSN       = "couponSn";
    public static final String COUPONDISCOUNT    = "couponDiscount";
    public static String       LONGITUDE      = "longitude";
    public static String       LATITUDE       = "latitude";//经度

    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;
    public static final String CARNAME= "carname";//当前默认的汽车品牌
    public static final String USER_PHONE= "user_phone";//
    public static final String PASSWORD= "password";//
    public static final String sessionID= "sessionID";//当前sessionid
    public static final String HEADIMAGE = "headimage";//头像

    public SpUtils(Context context) {
        mSp = context.getSharedPreferences("quansp", Context.MODE_PRIVATE);
        mEditor = mSp.edit();
    }

    /*--------------- 读 ---------------*/

    /**
     * 取出字符串信息
     *
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    /**
     * 取出整型信息
     *
     * @param key
     * @param defValue
     * @return
     */
    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    /**
     * 取出布尔类型信息
     *
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    /*--------------- 写 ---------------*/
    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }



    public void clear(){
        mEditor.clear().commit();
    }

}