package com.yunjae.rxjava.Session2;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by USER on 2018-03-13.
 */
public class PublishSubjectExample {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Subscriber #1 => " + data);
        });
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Subscriber #2 => " + data);
        });
        subject.onNext("4");
        subject.onComplete();
    }
}
