package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2018-03-21.
 */
public class SwitchMapExample {
    public static void main(String[] args) {
        test1();
        System.out.println("------------------------");
        test2();
    }

    private static void test1() {
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .switchMap(ball -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball + "<>")
                        .take(2));

        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }

    private static void test2() {
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable
                .interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .doOnNext(Log::dt)
                .switchMap(ball -> Observable
                        .interval(200L, TimeUnit.MILLISECONDS)
                        .map(notUsed -> ball + "<>")
                        .take(2));

        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }
}
