package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

/**
 * Created by USER on 2018-03-21.
 */
public class ScanExample {
    public static void main(String[] args) {
        String[] bills = {"1", "3", "5"};
        Observable<String> source = Observable
                .fromArray(bills)
                .scan((bill1, bill2) -> bill2 + "(" + bill1 + ")");
                //.scan(("0"), (bill1, bill2) -> bill2 + "(" + bill1 + ")");  // 초기값 지정

        source.subscribe(Log::i);
    }
}
