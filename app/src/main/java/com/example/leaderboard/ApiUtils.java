package com.example.leaderboard;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.leaderboard.SubmitRetrofitClient.getRetrofit;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";


    public static ApiInterface getApiInterface() {
        return SubmitRetrofitClient.getRetrofit(BASE_URL).create(ApiInterface.class);

    }

}





