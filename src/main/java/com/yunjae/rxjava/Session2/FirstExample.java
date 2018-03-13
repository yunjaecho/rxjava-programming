package com.yunjae.rxjava.Session2;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by USER on 2018-03-13.
 */
public class FirstExample {

    public void emit() {
        Observable.just(1,2,3,4,5,6)
                .subscribe(System.out::println);
    }

    public void emit2() {
        Observable<String> source = Observable.just("RED", "GREEN", "YELLOW");
        Disposable disposable = source.subscribe(
                v -> System.out.println("onNext() : value : " + v),
                err -> System.out.println("onError() : err :" + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("is Subscription : " + disposable.isDisposed());
    }

    public void emit3() {
        Observable observable = Observable.create(s -> {
            s.onNext(100);
            s.onNext(200);
            s.onNext(300);
            s.onComplete();
        });
        observable.subscribe(System.out::println);
    }

    public void emit4() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> observableEmitter) throws Exception {
                observableEmitter.onNext(100);
                observableEmitter.onNext(200);
                observableEmitter.onNext(300);
                observableEmitter.onComplete();
            }
        }).subscribe(System.out::println);
    }


    public static void main(String[] args) {
        FirstExample example = new FirstExample();
        example.emit4();
    }


}
