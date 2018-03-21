package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class DeferExample {
    Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();

    public static void main(String[] args) {
        DeferExample deferExample = new DeferExample();
        deferExample.marbleDiagram();
        deferExample.marbleDiagram2();
    }

    public void marbleDiagram() {
        Callable<Observable<String>> supplier = () -> getObservable();
        Observable<String> source = Observable.defer(supplier);

        source.subscribe(val -> Log.i("Subscriber #1: " + val));
        source.subscribe(val -> Log.i("Subscriber #2: " + val));
        CommonUtils.exampleComplete();
    }

    public void marbleDiagram2() {
        Observable<String> source = getObservable();

        source.subscribe(val -> Log.i("Subscriber #1: " + val));
        source.subscribe(val -> Log.i("Subscriber #2: " + val));
        CommonUtils.exampleComplete();
    }


    private Observable<String> getObservable() {
        if (colors.hasNext()) {
            String color = colors.next();
            return Observable.just(
                    Shape.getString(color, Shape.BALL),
                    Shape.getString(color, Shape.RECTANGLE),
                    Shape.getString(color, Shape.PENTAGON)
            );
        }
        return Observable.empty();
    }
}
