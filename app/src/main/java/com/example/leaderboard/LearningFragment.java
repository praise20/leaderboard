package com.example.leaderboard;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {
    private RecyclerView myRecyclerView;
    private MyAdapterHours myAdapter;
    private List<HourModel> usersList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Learning.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view = inflater.inflate(R.layout.fragment_learning, container, false);




        //Create a handler for the RetrofitInstance interface//
        GetDataHour service = RetrofitClient.getRetrofitInstance().create(GetDataHour.class);
        Call<List<HourModel>> call = service.getAllHours();
        //Execute the request asynchronously//
        call.enqueue(new Callback<List<HourModel>>() {
            @Override
            //Handle a successful response//
            public void onResponse(Call<List<HourModel>> call, Response<List<HourModel>> response) {
                loadDataList(response.body(), view);
            }
            @Override
            //Handle execution failures//
            public void onFailure(Call<List<HourModel>> call, Throwable throwable) {
                //If the request fails, then display the following toast//
                Toast.makeText(getActivity(), "Unable to load users", Toast.LENGTH_SHORT).show();
            }
            });



        return view;
    }



    //Display the retrieved data as a list//

    private void loadDataList(List<HourModel> usersList, View view) {

        //Get a reference to the RecyclerView//

        myRecyclerView = view.findViewById(R.id.hours_rv);

        myAdapter = new MyAdapterHours(usersList);

        //Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);
        //Set the Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);
    }


}


