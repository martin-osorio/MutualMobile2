package com.example.martinosorio.mutualmobile;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private static final String APP_ID = "1ff26352";
    private static final String APP_KEY = "6cab85e060940d39a7794da0ef4240f3";

    public void start(String searchTerm, Callback callback) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        EdamamAPI edamamAPI = retrofit.create(EdamamAPI.class);

        Map<String, String> data = new HashMap<>();
        data.put("q", searchTerm);
        data.put("app_id", APP_ID);
        data.put("app_key", APP_KEY);
        Call<EdamamReply> call = edamamAPI.getRecipies(data);
        call.enqueue(callback);
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().toString();
            if (response.isSuccessful()) {
                JSONObject returnJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = returnJSON.getJSONArray("hits");
                for (int i = 0; i < 10; i++) {
                    JSONObject recipeArrayJSON = recipesJSON.getJSONObject(i);
                    JSONObject recipeJSON = recipeArrayJSON.getJSONObject("recipe");
                    String name = recipeJSON.getString("label");
                    String imageUrl = recipeJSON.getString("image");
                    String sourceUrl = recipeJSON.getString("url");
                    String ingredients = recipeJSON.getJSONArray("ingredientLines").toString();

                    Recipe recipe = new Recipe (name, imageUrl, sourceUrl, ingredients);
                    recipes.add(recipe);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }
}