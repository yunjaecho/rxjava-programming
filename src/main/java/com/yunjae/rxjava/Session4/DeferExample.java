package com.yunjae.rxjava.Session4;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class DeferExample {
    Iterator<String> colors = Arrays.asList("1", "3", "5", "6").iterator();

    public static void main(String[] args) {



    }

    public void marbleDiagram() {
        Callable<Observable<String>> supplier = () -> getObservable();
    }

    private Observable<String> getObservable() {
        return null;
    }
}
