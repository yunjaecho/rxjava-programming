package com.yunjae.rxjava.Session2;

import io.reactivex.Observable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2018-03-13.
 */
public class ObservableFromIterable {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("William");
        names.add("Bob");

        Observable observable = Observable.fromIterable(names);
        observable.subscribe(System.out::println);
    }
}
