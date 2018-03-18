package com.yunjae.rxjava.Session3;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Gugudan Input");
        int dan = Integer.parseInt(in.nextLine());

        Observable<Integer> source = Observable.range(1 , 9);
        source.subscribe(row -> Log.i(dan + " * " + row + " = " + dan * row));

        Function<Integer, Observable<String>> gugudan =
                num -> Observable.range(1, 9).map(row-> num + " * " + row + " = " + num * row);

        System.out.println("=====================================");
        Observable
                .just(dan)
                .flatMap(gugudan)
                .subscribe(Log::i);

        System.out.println("=====================================");
        Observable
                .just(dan)
                .flatMap(gugu -> Observable.range(1, 9),
                        (gugu,i) -> gugu + " * " + " i = " + gugu * i)
                .subscribe(Log::i);

        in.close();
    }
}
