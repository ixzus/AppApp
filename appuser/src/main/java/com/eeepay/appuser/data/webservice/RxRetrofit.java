package com.eeepay.appuser.data.webservice;

import android.content.Context;

import com.eeepay.modulebase.net.HttpLogger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能描述:
 * Created by ixzus on 2017/10/12.
 */

public class RxRetrofit {
    private static RxRetrofit instance;
    private String BASE_URL = "http://gank.io/api/";

    private int DEFAULT_TIMEOUT = 30;

    private Retrofit retrofit;
    private WebService webService;

    public static RxRetrofit getInstance() {
        if (instance == null) {
            synchronized (RxRetrofit.class) {
                if (instance == null) {
                    instance = new RxRetrofit();
                }
            }
        }
        return instance;
    }

    public WebService getWebService() {
        return webService;
    }

    public RxRetrofit() {
        create();
    }

    public void create() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient())
                .build();
        webService = retrofit.create(WebService.class);

    }

    private OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT + 1, TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//        if (BuildConfig.DEBUG) {
        if (true) {
            HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            loggingInterceptor.setLevel(level);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }
}
