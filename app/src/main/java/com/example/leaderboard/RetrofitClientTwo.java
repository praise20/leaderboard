package com.example.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientTwo {
    private static Retrofit retrofit;

    //Define the base URL//

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    //Create the Retrofit instance//



    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    //Add Moshi’s converter factory//

                    //.addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
