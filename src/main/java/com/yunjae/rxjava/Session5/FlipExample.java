package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class FlipExample {
    public static void main(String[] args) {
        String[] objs = {"1-S", "2-T", "3-P"};
        Observable<String> source = Observable
                .fromArray(objs)
                .doOnNext(data -> Log.v("Original data = " + data))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .map(Shape::flip);

        source.subscribe(Log::i);
        CommonUtils.sleep(500);



    }

}
