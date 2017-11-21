package com.rosinante24.exploremuseum.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rosinante24 on 21/11/17.
 */

public class RetrofitConfig {
    public static Retrofit setInitRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://api.jakarta.go.id/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInitRetrofit() {
        return setInitRetrofit().create(ApiService.class);
    }
}
