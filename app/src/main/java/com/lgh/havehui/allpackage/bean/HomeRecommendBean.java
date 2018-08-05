package com.lgh.havehui.allpackage.bean;

import java.util.List;

/**
 * 作者 : 李观鸿
 * Created by MyPC on 2017/12/26.
 */

public class HomeRecommendBean {

    private int status;
    private String         msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int    id;
        private int    index_type;
        private String product_id;
        private String product_name;
        private String platform_name;
        private String main_pic;
        private String detail_url;
        private String category_first;
        private int    category_id;
        private String taoke_url;
        private String price;
        private int    buy_num;
        private int    config_time;
        private int    start_time;
        private int    end_time;
        private String income_percent;
        private String commission;
        private String seller_wangwang;
        private int    seller_id;
        private String shop_name;
        private String coupon_id;
        private int    coupon_totalnum;
        private int    coupon_lastnum;
        private String coupon_value;
        private int    coupon_start_time;
        private int    coupon_end_time;
        private String coupon_url;
        private String coupon_promotion_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIndex_type() {
            return index_type;
        }

        public void setIndex_type(int index_type) {
            this.index_type = index_type;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getPlatform_name() {
            return platform_name;
        }

        public void setPlatform_name(String platform_name) {
            this.platform_name = platform_name;
        }

        public String getMain_pic() {
            return main_pic;
        }

        public void setMain_pic(String main_pic) {
            this.main_pic = main_pic;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getCategory_first() {
            return category_first;
        }

        public void setCategory_first(String category_first) {
            this.category_first = category_first;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getTaoke_url() {
            return taoke_url;
        }

        public void setTaoke_url(String taoke_url) {
            this.taoke_url = taoke_url;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(int buy_num) {
            this.buy_num = buy_num;
        }

        public int getConfig_time() {
            return config_time;
        }

        public void setConfig_time(int config_time) {
            this.config_time = config_time;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public String getIncome_percent() {
            return income_percent;
        }

        public void setIncome_percent(String income_percent) {
            this.income_percent = income_percent;
        }

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getSeller_wangwang() {
            return seller_wangwang;
        }

        public void setSeller_wangwang(String seller_wangwang) {
            this.seller_wangwang = seller_wangwang;
        }

        public int getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(int seller_id) {
            this.seller_id = seller_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(String coupon_id) {
            this.coupon_id = coupon_id;
        }

        public int getCoupon_totalnum() {
            return coupon_totalnum;
        }

        public void setCoupon_totalnum(int coupon_totalnum) {
            this.coupon_totalnum = coupon_totalnum;
        }

        public int getCoupon_lastnum() {
            return coupon_lastnum;
        }

        public void setCoupon_lastnum(int coupon_lastnum) {
            this.coupon_lastnum = coupon_lastnum;
        }

        public String getCoupon_value() {
            return coupon_value;
        }

        public void setCoupon_value(String coupon_value) {
            this.coupon_value = coupon_value;
        }

        public int getCoupon_start_time() {
            return coupon_start_time;
        }

        public void setCoupon_start_time(int coupon_start_time) {
            this.coupon_start_time = coupon_start_time;
        }

        public int getCoupon_end_time() {
            return coupon_end_time;
        }

        public void setCoupon_end_time(int coupon_end_time) {
            this.coupon_end_time = coupon_end_time;
        }

        public String getCoupon_url() {
            return coupon_url;
        }

        public void setCoupon_url(String coupon_url) {
            this.coupon_url = coupon_url;
        }

        public String getCoupon_promotion_url() {
            return coupon_promotion_url;
        }

        public void setCoupon_promotion_url(String coupon_promotion_url) {
            this.coupon_promotion_url = coupon_promotion_url;
        }
    }
}
