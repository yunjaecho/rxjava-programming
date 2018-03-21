package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.Shape;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static com.yunjae.rxjava.util.Shape.*;

/**
 * Created by USER on 2018-03-21.
 */
public class ZipExample {
    public static void main(String[] args) {
        zip();
        System.out.println("-----------------------------");
        zipInterval();
    }

    private static void zip() {
        String[] shapes = {BALL, PENTAGON, STAR};
        String[] coloredTriangles = {triangle(YELLOW), triangle(PUPPLE), triangle(SKY)};
        String[] strings = {"BALL", "PENTAGON", "STAR"};

        // 최대 9개까지 Observable 처리
        Observable<String> source = Observable.zip(
                Observable.fromArray(shapes).map(Shape::getSuffix),
                Observable.fromArray(coloredTriangles).map(Shape::getColor),
                Observable.fromArray(strings),
                (suffix, color, string) -> string + color + suffix
        );

        source.subscribe(Log::i);
    }

    private static void zipInterval() {
        Observable<String> source = Observable.zip(
                Observable.just("RED", "GREEN", "BLUE"),
                Observable.interval(200L, TimeUnit.MILLISECONDS),
                (zip1, zip2) -> zip1 + zip2
        );

        CommonUtils.exampleStart();
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
