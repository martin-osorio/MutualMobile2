package com.example.martinosorio.mutualmobile;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Martin on 3/22/2018.
 */

public class Recipe {

    @SerializedName("label")
    private String name;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("url")
    private String sourceUrl;

    //private String[] ingredients;
}
