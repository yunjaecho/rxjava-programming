package com.yunjae.rxjava.Session4;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;

import java.util.Scanner;

public class ReactiveSum {
    public static void main(String[] args) {
        new ReactiveSum().run();
    }

    public void run() {
        ConnectableObservable<String> source = userInput();
        Observable<Integer> a = source
                .filter(str -> str.startsWith("a:"))
                .map(str -> str.replace("a:", ""))
                .map(Integer::parseInt);

        Observable<Integer> b = source
                .filter(str -> str.startsWith("b:"))
                .map(str -> str.replace("b:", ""))
                .map(Integer::parseInt);

        Observable.combineLatest(
                a.startWith(0),
                b.startWith(0),
                (x , y) -> x + y)
                .subscribe(res -> System.out.println("Result : " + res));
        // connect 메소드 호출시 그때 부터 호출됨
        source.connect();

    }

    private ConnectableObservable<String> userInput() {
        return Observable.create((ObservableEmitter<String> emitter) -> {
            Scanner in = new Scanner(System.in);
            while(true) {
                System.out.println("Input:");
                String line = in.nextLine();
                emitter.onNext(line);

                if (line.indexOf("exit") >= 0) {
                    in.close();
                    break;
                }
            }
        }).publish();

    }
}
