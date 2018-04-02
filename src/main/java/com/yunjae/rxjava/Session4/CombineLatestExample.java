package com.yunjae.rxjava.Session4;


import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatestExample {
    public static void main(String[] args) {
        String[] data1 = {"6", "7", "4", "2"};
        String[] data2 = {"DIAMOND", "STAR", "PENTAGO"};

        Observable<String> source = Observable.combineLatest(
            Observable.fromArray(data1)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
                         (shape, notUsed) -> Shape.getColor(shape)),
            Observable.fromArray(data2)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
                        (shape, notUsed) -> Shape.getSuffix(shape)),
             (v1, v2) -> v1 + v2);

        source.subscribe(Log::i);
        CommonUtils.sleep(1000);
    }
}
