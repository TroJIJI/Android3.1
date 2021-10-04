package com.example.android31;

import android.app.Application;

import com.example.android31.data.remote.ApiService;
import com.example.android31.data.remote.RetrofitClient;

public class App extends Application {

    public static ApiService service;


    @Override
    public void onCreate() {
        super.onCreate();
        service=new RetrofitClient().provideApiService();
    }
}
