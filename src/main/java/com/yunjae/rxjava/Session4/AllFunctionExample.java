package com.yunjae.rxjava.Session4;


import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public class AllFunctionExample {
    public static void main(String[] args) {
        String[] data = {"1", "2", "3", "4"};

        Single<Boolean> source = Observable.fromArray(data)
                .map(Shape::getShape)
                .all(Shape.BALL::equals);

        source.subscribe((Consumer<? super Boolean>) Log::i);

        //source.subscribe(value -> System.out.println(value));
    }

}
