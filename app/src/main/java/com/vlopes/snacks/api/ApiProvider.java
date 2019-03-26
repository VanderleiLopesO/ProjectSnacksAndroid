package com.vlopes.snacks.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.vlopes.snacks.api.UserApi;

public class ApiProvider {

    protected static UserApi mService;

    public static UserApi getApi() {
        return mService;
    }

    public static Retrofit getRetrofitInstance(String baseUrl) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

}
