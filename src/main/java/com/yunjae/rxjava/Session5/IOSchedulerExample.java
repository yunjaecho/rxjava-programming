package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.File;

public class IOSchedulerExample {
    public static void main(String[] args) {
        File[] files = new File("/home/comp1").listFiles();
        Observable<String> source = Observable.fromArray(files)
                .filter(f -> f.isDirectory())
                .map(f -> f.getAbsolutePath())
                .subscribeOn(Schedulers.io());

        source.subscribe(Log::i);
        CommonUtils.sleep(500);

    }
}
