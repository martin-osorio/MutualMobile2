package com.example.martinosorio.mutualmobile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Martin on 3/22/2018.
 */

public class EdamamReply {

    @SerializedName("hits")
    private List<Recipe> recipes = null;

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
