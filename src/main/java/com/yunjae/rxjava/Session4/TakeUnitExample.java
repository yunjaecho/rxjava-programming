package com.yunjae.rxjava.Session4;


import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class TakeUnitExample {
    public static void main(String[] args) {
        String[] data = {"1", "2", "3", "4", "5", "6"};

        Observable<String> source =
                Observable
                    .fromArray(data)
                    .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, notUsed) -> val)
                    .takeUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);


        Observable<String> source2 = Observable.fromArray(data);
        source2.zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, notUsed) -> val)
               .takeUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));

        source2.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
