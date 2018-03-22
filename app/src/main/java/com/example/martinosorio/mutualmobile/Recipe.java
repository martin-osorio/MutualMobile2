package com.example.martinosorio.mutualmobile;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 3/22/2018.
 */

public class Recipe {

    public Recipe(String name, String imageUrl, String sourceUrl, String ingredients) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.sourceUrl = sourceUrl;
        this.ingredients = ingredients.replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\\\","").split("\",\"");
    }

    @SerializedName("label")
    private String name;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("url")
    private String sourceUrl;

    private String[] ingredients;
}
