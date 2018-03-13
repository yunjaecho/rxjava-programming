package com.yunjae.rxjava.Session2;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

/**
 * Created by USER on 2018-03-13.
 */
public class AsyncSubjectExample {
    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("2");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onComplete();
        subject.onNext("4");

        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);
        AsyncSubject<Float> subject2 = AsyncSubject.create();
        subject2.subscribe(data -> System.out.println("Subscriber #3 => " + data));
        source.subscribe(subject2);


    }
}
