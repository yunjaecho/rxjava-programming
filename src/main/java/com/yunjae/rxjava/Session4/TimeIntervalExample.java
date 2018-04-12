package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

public class TimeIntervalExample {
    public static void main(String[] args) {
        String[] data = {"1", "3", "7"};

        CommonUtils.exampleStart();

        Observable
                .fromArray(data)
                .delay(item -> {
                    CommonUtils.doSomething();
                    return Observable.just(item);
                })
                .timeInterval()
                .subscribe(Log::i);

        CommonUtils.sleep(1000);


    }
}
