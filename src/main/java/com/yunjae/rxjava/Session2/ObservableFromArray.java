package com.yunjae.rxjava.Session2;

import io.reactivex.Observable;

import java.util.stream.IntStream;

/**
 * Created by USER on 2018-03-13.
 */
public class ObservableFromArray {
    public static void main(String[] args) {
        Integer[] arr = {100,200,3000};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);

        int[] arr2 = {100,200,3000};
        Observable<Integer> source2 = Observable.fromArray(toInteger(arr2));
        source2.subscribe(System.out::println);
    }

    /**
     * int[] to Integer[]
     * @param intArray
     * @return
     */
    private static Integer[] toInteger(int[] intArray) {
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }
}
