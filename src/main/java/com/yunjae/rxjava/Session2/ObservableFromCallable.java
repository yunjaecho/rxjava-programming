package com.yunjae.rxjava.Session2;

import io.reactivex.Observable;

import java.util.concurrent.Callable;

/**
 * Created by USER on 2018-03-13.
 */
public class ObservableFromCallable {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
          Thread.sleep(1000);
          return "Hello Callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }


}
