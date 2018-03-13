package com.yunjae.rxjava.Session2;

import com.yunjae.rxjava.util.Order;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by USER on 2018-03-13.
 */
public class SingleExample {
    public static void main(String[] args) {
        //1. 기존에 Observable 에서 Single 객체로 변환하기
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        // 2. single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single")
                .single("default from")
                .subscribe(System.out::println);

        //3. first() 함수를 호출해 Single 객체 생성하기
        String[] colors = {"Red", "Blue", "Gold"};
        Observable.fromArray(colors)
                .first("default from")
                .subscribe(System.out::println);

        // 4. empty Observable 에서 Single 객체 생성하기
        Observable.empty()
                .single("default from")
                .subscribe(System.out::println);

        // 5. take() 함수에서 Single 객체 생성하기
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default from"))
                .subscribe(System.out::println);

        // Error case
        Observable<String> source2 = Observable.just("Hello Single", "Error", "aaaa");
        Single.fromObservable(source2)
                .subscribe(System.out::println);

    }
}
