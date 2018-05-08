package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class NewThreadSchedularExample {
    public static void main(String[] args) {
        String[] orgs = {"1", "3", "5"};
        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data : " + data))
                .map(data -> "<<" + data + ">>")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);

        CommonUtils.sleep(500);

        Observable.fromArray(orgs)
                .doOnNext(data -> Log.v("Original data : " + data))
                .map(data -> "##" + data + "##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
