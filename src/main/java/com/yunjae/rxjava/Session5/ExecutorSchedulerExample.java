package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 자바에서 java.util.current 패키지에서 제공하는 실행자(Executor)를 변환하여 스케쥴러를 생성
 * 할수 있습니다. 하지만 Executor 클래스와 스케쥴러의 동작방식과 다르므로 추천 방법은 아닙니다.
 * 기존에 사용하던 Executor 클래스를 재사용할 때만 한정적으로 황용합니다.
 */
public class ExecutorSchedulerExample {
    public static void main(String[] args) {
        final int HREAD_NUM = 10;

        String[] data = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(data);
        Executor executor = Executors.newFixedThreadPool(HREAD_NUM);

        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);

        source.subscribeOn(Schedulers.from(executor))
                .subscribe(Log::i);

        CommonUtils.sleep(500);
    }
}
