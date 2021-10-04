package com.example.android31.data.remote;

import com.example.android31.data.models.MainResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiService {

    @GET("api/character")
    Call<MainResponse> fetchCharacters();


}
