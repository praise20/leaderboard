package com.example.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitRetrofitClient {

//    public static final String baseUrl = "https://docs.google.com/forms/d/e/";
    private static Retrofit retrofit = null;


    public static Retrofit getRetrofit(String baseUrl) {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                      .baseUrl(baseUrl)
                      .addConverterFactory(GsonConverterFactory.create())
                      .build();
        }
        return retrofit;
    }
}
