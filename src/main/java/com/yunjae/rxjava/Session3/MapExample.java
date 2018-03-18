package com.yunjae.rxjava.Session3;


import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class MapExample {
    public static void main(String[] args) {
        Function<String, String> getDiamond = ball -> ball + "<>";

        String[] balls = {"1", "2", "3", "5"};
        Observable<String> source = Observable.fromArray(balls).map(getDiamond);

        source.subscribe(Log::i);
    }
}
