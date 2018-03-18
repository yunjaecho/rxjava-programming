package com.yunjae.rxjava.Session3;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {
    public static void main(String[] args) {
        Function<String, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "<>", ball + "<>");

        String[] balls = {"1", "2", "3", "5"};

        Observable<String> source = Observable.fromArray(balls).flatMap(getDoubleDiamonds);
        source.subscribe(Log::i);

        Observable<String> source2 = Observable.fromArray(balls).flatMap(ball -> Observable.just(ball + "<>", ball + "<>"));
        source.subscribe(Log::i);
    }
}
