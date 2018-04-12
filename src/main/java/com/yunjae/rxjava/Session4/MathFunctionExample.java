package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.Log;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MathFunctionExample {
    public static void main(String[] args) {
        Integer[] data = {1,2,3,4,};

        // 1. count()
        Single<Long> source = Observable.fromArray(data)
                .count();
        source.subscribe(count -> Log.i("count is " + count));

        // 2. max() , min()
        Flowable.fromArray(data)
                .to(MathFlowable::max)
                .subscribe(max -> Log.i("max is " + max));

        Flowable.fromArray(data)
                .to(MathFlowable::min)
                .subscribe(min -> Log.i("min is " + min));

        // 3. sum() , average()
        Flowable.fromArray(data)
                .to(MathFlowable::sumInt)
                .subscribe(sumInt -> Log.i("sumInt is " + sumInt));

        Flowable.fromArray(data)
                //.toFlowable(BackpressureStrategy.BUFFER)
                .to(MathFlowable::averageDouble)
                .subscribe(averageDouble -> Log.i("averageDouble is " + averageDouble));

        // Observable change to Flowable (.toFlowable(BackpressureStrategy.BUFFER))
        // BackpressureStrategy.BUFFER : Backpressure basic strategy
        Observable.fromArray(data)
                .toFlowable(BackpressureStrategy.BUFFER)
                .to(MathFlowable::averageDouble)
                .subscribe(averageDouble -> Log.i("averageDouble is " + averageDouble));
    }
}
