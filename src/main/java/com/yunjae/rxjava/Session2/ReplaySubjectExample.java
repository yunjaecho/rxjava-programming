package com.yunjae.rxjava.Session2;

import io.reactivex.subjects.ReplaySubject;

/**
 * Created by USER on 2018-03-13.
 */
public class ReplaySubjectExample {
    public static void main(String[] args) {
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("5");
        subject.onComplete();
    }
}
