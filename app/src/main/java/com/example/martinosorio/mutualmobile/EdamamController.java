package com.example.martinosorio.mutualmobile;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Martin on 3/22/2018.
 */

public class EdamamController {
    private static final String BASE_URL = "https://api.edamam.com/";
    private static final String APP_ID = "https://api.edamam.com/";
    private static final String APP_KEY = "https://api.edamam.com/";

    public void start(String searchTerm, Callback callback) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        EdamamAPI edamamAPI = retrofit.create(EdamamAPI.class);
        Call<EdamamReply> call = edamamAPI.getRecipies(searchTerm, APP_ID, APP_KEY);
        call.enqueue(callback);
    }

    /*@Override
    public void onResponse(@NonNull Call<EdamamReply> call, @NonNull Response<EdamamReply> response) {
        if (response.isSuccessful()) {
            EdamamReply reply = response.body();
            if (reply != null) {
                //EventBus.getDefault().post(new FilmsDownloadedEvent(reply.getFilms()));
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(@NonNull Call<EdamamReply> call, @NonNull Throwable t) {
        t.printStackTrace();
    }*/
}