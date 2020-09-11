package com.example.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataSkill {

    //Specify the request type and pass the relative URL//
    @GET("/api/skilliq")
    //Wrap the response in a Call object with the type of the expected result//
    Call<List<SkillModel>> getAllSkill();
}
