package com.yunjae.rxjava.Session5;


import com.yunjae.rxjava.util.CommonUtils;
import com.yunjae.rxjava.util.Log;
import com.yunjae.rxjava.util.OkHttpHelper;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.yunjae.rxjava.util.CommonUtils.API_KEY;

public class OpenWeatherMapV1 {
    private static final String URL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    public static void main(String[] args) {
        OpenWeatherMapV1 demo = new OpenWeatherMapV1();
        //demo.run();
        demo.runJustOne();
    }


    public void run() {
        Observable<String> source = Observable.just(URL)
                .map(OkHttpHelper::getWithLog)
                .subscribeOn(Schedulers.io());

        // 어떻게 한번만 호출하게 만들 수 있을까요?
        Observable<String> temperature = source.map(this::parseTemperature);
        Observable<String> city = source.map(this::parseCityName);
        Observable<String> country = source.map(this::parseCountry);
        CommonUtils.exampleStart();

        Observable.concat(temperature, city, country)
                .observeOn(Schedulers.newThread())
                .subscribe(Log::i);

        CommonUtils.sleep(5000);
    }

    public void runJustOne() {
        CommonUtils.exampleStart();

        Observable<String> source = Observable.just(URL)
                .map(OkHttpHelper::getWithLog)
                .subscribeOn(Schedulers.io())
                .share()
                .observeOn(Schedulers.newThread());


        // 한번에 처리
        source.map(this::parseTemperature).subscribe(Log::i);
        source.map(this::parseCityName).subscribe(Log::i);
        source.map(this::parseCountry).subscribe(Log::i);

        CommonUtils.sleep(5000);
    }

    private String parseTemperature(String json) {
        String retVal = parse(json, "\"temp\":[0-9]*.[0-9]*");
        System.out.println("parseTemperature : " + retVal);
        return retVal;
    }

    private String parseCityName(String json) {
        String retVal = parse(json, "\"name\":\"[a-zA-Z]*\"");
        System.out.println("parseCityName : " + retVal);
        return retVal;
    }

    private String parseCountry(String json) {
        String retVal = parse(json, "\"country\":\"[a-zA-Z]*\"");
        System.out.println("parseCountry : " + retVal);
        return retVal;
    }

    private String parse(String json, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(json);
        if (match.find()) {
            return match.group();
        }
        return "N/A";
    }

}
