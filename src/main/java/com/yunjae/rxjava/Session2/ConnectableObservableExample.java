package com.yunjae.rxjava.Session2;

import com.yunjae.rxjava.util.CommonUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2018-03-13.
 */
public class ConnectableObservableExample {
    public static void main(String[] args) {
        String[] dt = {"1","3", "5"};

        Observable<String> balls =
                Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(i -> dt[i])
                .take(dt.length);

        ConnectableObservable<String> source = balls.publish();
        source.subscribe(data -> System.out.println("Subscriber #1 =>" + data));
        source.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
        source.connect();

        CommonUtils.sleep(250);
        source.subscribe(data -> System.out.println("Subscriber #3 =>" + data));
        CommonUtils.sleep(100);
    }
}
