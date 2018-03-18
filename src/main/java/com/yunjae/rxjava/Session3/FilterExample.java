package com.yunjae.rxjava.Session3;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

public class FilterExample {
    public static void main(String[] args) {
        String[] objs = {"1 CIRCLE", "2 DIAMOND", "3 TRIANGLE", "4 DIAMOND", "5 CIRCLE", "6 HEXAGON"};

        Observable
                .fromArray(objs)
                .filter(obj -> obj.endsWith("CIRCLE"))
                .subscribe(Log::i);

        Integer[] numbers = {100, 200, 300, 400, 500};

        System.out.println("1. first");
        Observable.fromArray(numbers)
                .first(-1)
                .subscribe(data -> System.out.println("first() value : " + data));

        System.out.println("2. last");
        Observable.fromArray(numbers)
                .last(999)
                .subscribe(data -> System.out.println("last() value : " + data));

        System.out.println("3. take(n)");
        Observable.fromArray(numbers)
                .take(3)
                .subscribe(data -> System.out.println("take(3) value : " + data));

        System.out.println("4. takeLast(n)");
        Observable.fromArray(numbers)
                .takeLast(3)
                .subscribe(data -> System.out.println("takeLast(3) value : " + data));

        System.out.println("5. skip(n)");
        Observable.fromArray(numbers)
                .skip(2)
                .subscribe(data -> System.out.println("skip(2) value : " + data));

        System.out.println("6. skipLast(n)");
        Observable.fromArray(numbers)
                .skipLast(2)
                .subscribe(data -> System.out.println("skipLast(2) value : " + data));
    }


}
