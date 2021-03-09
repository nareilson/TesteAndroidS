package com.example.testeandroids.repository.service;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private HttpUrl getUrlBase(){
        return new HttpUrl.Builder()
                .scheme("http")
                .host("pokeapi.co")
                .encodedPath("/api/v2/")
                .build();
    }
    private Retrofit getRetrofitService(){
        return new Retrofit.Builder()
                .baseUrl(getUrlBase())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(getHattpClient())
                .build();
    }

    private OkHttpClient getHattpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient
                .Builder()
                .readTimeout(1,TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1,TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
    }

    public PokeApiService getPokeApiService(){
        return  getRetrofitService().create(PokeApiService.class);
    }
}
