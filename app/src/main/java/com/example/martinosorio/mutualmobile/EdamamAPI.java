package com.example.martinosorio.mutualmobile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Martin on 3/22/2018.
 */

public interface EdamamAPI {
    //String APPID = "1ff26352";
    //String APPKEY = "6cab85e060940d39a7794da0ef4240f3";

    @GET("search")
    Call<EdamamReply> getRecipies(
            @Path("q") String searchTerm,
            @Path("app_id") String appID,
            @Path("app_key") String appKey
    );
}
