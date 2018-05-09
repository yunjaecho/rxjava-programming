package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.OkHttpHelper;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.yunjae.rxjava.util.CommonUtils.GITHUB_ROOT;

public class CallbackHeaven {

    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = GITHUB_ROOT + "/samples/callback_heaven";

    public void usingConcat() {
        CommonUtils.exampleStart();

        Observable<String> source = Observable.just(FIRST_URL)
            .subscribeOn(Schedulers.io())
            .map(OkHttpHelper::get)
            .concatWith(Observable.just(SECOND_URL)
            .map(OkHttpHelper::get));

        source.subscribe(Log::i);
        CommonUtils.sleep(5000);
        CommonUtils.exampleComplete();
    }

    public void usingZip() {
        CommonUtils.exampleStart();

        Observable<String> first = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);

        Observable<String> second = Observable.just(SECOND_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);

        Observable.zip(first, second, (a, b) -> ("\n>>" + a + "\n>>" + b))
                .subscribe(Log::i);

        CommonUtils.sleep(5000);
        CommonUtils.exampleComplete();
    }

    public static void main(String[] args) {
        CallbackHeaven callbackHeaven = new CallbackHeaven();
        //callbackHeaven.usingConcat();
        callbackHeaven.usingZip();
    }
}
