package com.yunjae.rxjava.Session3;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

public class ReduceExample {
    public static void main(String[] args) {
        String[] balls = {"1", "2", "5"};
        Observable
                .fromArray(balls)
                .reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")")
                //.reduce(("0"), (ball1, ball2) -> ball2 + "(" + ball1 + ")") // 초기값 지정
                .subscribe(System.out::println);
    }
}
