package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.observables.GroupedObservable;

/**
 * Created by USER on 2018-03-21.
 */
public class GroupByExample {
    public static void main(String[] args) {
        test1();
        System.out.println("--------------------------------");
        fillter();
    }

    private static void test1() {
        String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
        Observable<GroupedObservable<String, String>> source =
                Observable.fromArray(objs)
                .groupBy(Shape::getShape);

        source.subscribe(obj -> {
            obj.subscribe(val -> System.out.println("GROUP: " + obj.getKey() + "\tValue : " + val));
        });
    }


    private static void fillter() {
        String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
        Observable<GroupedObservable<String, String>> source =
                Observable.fromArray(objs)
                        .groupBy(Shape::getShape)
                .filter(s -> s.getKey().equals(Shape.BALL))
                ;

        source.subscribe(obj -> {
            obj.subscribe(val -> System.out.println("GROUP: " + obj.getKey() + "\tValue : " + val));
        });
    }



}
