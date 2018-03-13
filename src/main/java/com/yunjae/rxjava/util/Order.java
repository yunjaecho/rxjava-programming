package com.yunjae.rxjava.util;

/**
 * Created by USER on 2018-03-13.
 */
public class Order {
    private String mId;

    public Order(String mId) {
        this.mId = mId;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "Order Id : " + mId;
    }
}
