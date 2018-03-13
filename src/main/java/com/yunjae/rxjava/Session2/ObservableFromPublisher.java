package com.yunjae.rxjava.Session2;

import io.reactivex.Observable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/**
 * Created by USER on 2018-03-13.
 */
public class ObservableFromPublisher {
    public static void main(String[] args) {
        Publisher<String> publisher = (Subscriber<? super String> s) -> {
           s.onNext("Hello Observable fromPublisher");
           s.onComplete();
        };

        Publisher<String> publisher2 = (s -> {
            s.onNext("Hello Observable fromPublisher");
            s.onComplete();
        });

        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);

        Observable<String> source2 = Observable.fromPublisher(publisher);
        source2.subscribe(System.out::println);
    }
}
