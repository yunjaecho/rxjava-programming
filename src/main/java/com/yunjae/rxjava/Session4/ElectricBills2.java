package com.yunjae.rxjava.Session4;

import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import org.apache.commons.lang3.tuple.Pair;

import java.text.DecimalFormat;

import static java.lang.Integer.*;

public class ElectricBills2 {
    private static String[] data = {"100", "200", "255"};
    // 오류 발생
    //private static String[] data = {"100", "200", "25a5"};
    // 빈 리스트
    //private static String[] data = {};


    public static void main(String[] args) {
        Observable<Integer> basePrice =
                Observable
                        .fromArray(data)
                        .map(Integer::parseInt)
                        .map(val -> {
                            if (val <= 200) return 910;
                            if (val <= 400) return 1600;
                            return 7300;
                        });


        Observable<Integer> usagePrice =
                Observable
                        .fromArray(data)
                        .map(Integer::parseInt)
                        .map(val -> {
                            double series1 = min(200, val) * 93.3;
                            double series2 = min(200, max(val-200,0)) * 187.9;
                            double series3 = min(0, max(val-400, 0)) * 280.65;
                            return (int) (series1 + series2 + series3);
                        });

        Observable<Pair<String, Integer>> source = Observable
                .zip(basePrice,
                     usagePrice,
                     Observable.fromArray(data),
                        (v1, v2, i) -> Pair.of(i, v1+v2));

        // subscribe method argument
        //  onNext  : onNext Consumer 함수
        //  onError : 오류시 처리 Consumer 함수
        //  onComplete : 성공시 처리 Consumer 함수
        //  Functions.emptyConsumer() :
        source
                .map(val -> Pair.of(val.getLeft(),
                        new DecimalFormat("#,###").format(val.getValue())))
//                 .doOnNext(val -> {
//                     StringBuilder sb = new StringBuilder();
//                     sb.append("Usage : " + data[index] + "kWh => ");
//                     sb.append("Price : " + val + "원");
//                     index++;   // 부수적효과
//                     System.out.println(sb.toString());
//                 })
                .subscribe(val -> {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Usage : " +val.getLeft() + "kWh => ");
                            sb.append("Price : " + val.getRight() + "원");
                            Log.i(sb.toString());
                        },throwable -> System.out.println(throwable.getMessage())
                        , () -> System.out.println("complete")) ;



    }
}
