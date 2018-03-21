package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.OkHttpHelper;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2018-03-21.
 */
public class RepeatExample {
    public static void main(String[] args) {
        repeat1();
        heartbeatV1();
    }

    private static void repeat1() {
        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .fromArray(balls)
                .repeat(3)
                .doOnComplete(() -> Log.d("doOnComplete"));

        source.subscribe(Log::i);
    }

    private static void heartbeatV1() {
        CommonUtils.exampleStart();
        String serverUrl = "https://github.com";

        Observable.timer(2, TimeUnit.SECONDS)
                .map(val -> serverUrl)
                .map(OkHttpHelper::get)
                .repeat()
                .subscribe(res -> Log.it("Ping Result : " + res));

        CommonUtils.sleep(10000);
    }


}
