package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class AmbExample {
    public static void main(String[] args) {
        String[] data1 =  {"1", "3", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        String[] data2 = {"2-R", "4-R"};

        List<Observable<String>> source = Arrays.asList(
           Observable.fromArray(data1)
           .doOnComplete(() -> Log.d("Observalbe #1 : onComplete")),

           Observable.fromArray(data2)
                        .doOnComplete(() -> Log.d("Observalbe #2 : onComplete"))
        );

        Observable
            .amb(source)
            .doOnComplete(() -> Log.d("Result : onComplete"))
            .subscribe(Log::i);

        CommonUtils.sleep(1000);


    }
}
