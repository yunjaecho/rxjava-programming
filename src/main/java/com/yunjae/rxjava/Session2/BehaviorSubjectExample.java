package com.yunjae.rxjava.Session2;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by USER on 2018-03-13.
 */
public class BehaviorSubjectExample {
    public static void main(String[] args) {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("4");
        subject.onNext("5");
        subject.onComplete();
    }
}
