package com.example.laksh.viperdemo.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laksh on 9/11/17.
 */

public class WebApi {

   private static Retrofit mRetrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("Your Base URL")
            .build();

    public static  WebServiceApi getService() {
        return (mRetrofit.create(WebServiceApi.class));
    }


}
