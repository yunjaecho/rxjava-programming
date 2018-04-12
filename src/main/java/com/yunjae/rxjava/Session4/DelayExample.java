package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DelayExample {
    public static void main(String[] args) {
        String[] data = {"1", "7", "2", "3", "4"};
        Observable
                .fromArray(data)
                .delay(100L, TimeUnit.MILLISECONDS)
                .subscribe(Log::it);

        CommonUtils.sleep(1000);
    }
}
