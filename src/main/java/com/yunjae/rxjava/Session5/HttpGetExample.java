package com.yunjae.rxjava.Session5;

import com.yunjae.rxjava.util.Log;
import okhttp3.*;

import java.io.IOException;

public class HttpGetExample {
    private final OkHttpClient client = new OkHttpClient();

    private static final String FIRST_URL = "http://ww17.raw.githubsercontent.com/yudong80/reativejava/master/README.md";
    //private static final String SECOND_URL = "http://www.jobaccept.com/jobs/register_jobalerts.jsp?CID=2725&job=Call%20Center&SID=2725A0057";


    public void run() {
        Request request = new Request
                .Builder()
                .url(FIRST_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(response.body().toString());
            }
        });

    }

    public static void main(String[] args) {
        HttpGetExample demo = new HttpGetExample();
        demo.run();
    }
}
