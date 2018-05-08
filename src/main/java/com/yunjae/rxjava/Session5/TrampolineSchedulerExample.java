package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


/**
 * 트램펄린 스케줄러를 이용하면 실행순서가 변경되지 않음
 */
public class TrampolineSchedulerExample {
    public static void main(String[] args) {
        String[] orgs = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(orgs);

        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "<<" + data + ">>")
                .subscribe(Log::i);


        source.subscribeOn(Schedulers.trampoline())
                .map(data -> "##" + data + "##")
                .subscribe(Log::i);

        CommonUtils.sleep(1000);
    }
}
