package com.example.martinosorio.mutualmobile;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Martin on 3/22/2018.
 */

public interface EdamamAPI {

    @GET("search")
    Call<EdamamReply> getRecipies(@QueryMap Map<String, String> options);
}
