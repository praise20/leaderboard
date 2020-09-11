package com.example.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataHour {

    //Specify the request type and pass the relative URL//
        @GET("/api/hours")
    //Wrap the response in a Call object with the type of the expected result//
        Call<List<HourModel>> getAllHours();

}

