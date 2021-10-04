package com.example.android31.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final Retrofit provideRetrofit = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/").addConverterFactory(GsonConverterFactory.create()).build();

    public ApiService provideApiService(){
        return provideRetrofit.create(ApiService.class);
    }
}
