package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private ApiInterface mApiInterface;
    EditText firstName, lastName, emailAddress, githubUrl;
    Button submitBtn;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);


        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.submit_toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        //post Retrofit response
        firstName  = (EditText) findViewById(R.id.first_name);
        lastName= (EditText) findViewById(R.id.last_name);
        emailAddress = (EditText) findViewById(R.id.email);
        githubUrl = (EditText) findViewById(R.id.github);
        submitBtn = (Button) findViewById(R.id.submit_post);

        mApiInterface = ApiUtils.getApiInterface();

        // add button listener
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_dialogue);
                Button dialogButton = (Button) dialog.findViewById(R.id.yes_button);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickDialogue();


                    }
                });
                dialog.show();
            }

        });


    }


    private void clickDialogue() {

        if (firstName.getText().toString().length() > 0 && lastName.getText().toString().length() > 0
                && emailAddress.getText().toString().length() > 0 && githubUrl.getText().toString().length() > 0 ) {

            Toast.makeText(getApplicationContext(),"Sending network post",Toast.LENGTH_SHORT).show();

            sendPost(firstName.getText().toString(), lastName.getText().toString(),
                    emailAddress.getText().toString(), githubUrl.getText().toString());

        }
        else {

            Toast.makeText(getApplicationContext(),"Missing Required Information!",Toast.LENGTH_SHORT).show();
        }

    }

    private void sendPost(String firstName, String lastName, String emailAddress, String githubUrl) {
        mApiInterface.savePost(firstName, lastName, emailAddress, githubUrl)
                .enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                String s1=Boolean.toString(response.isSuccessful());
                String s2= new Integer(response.code()).toString();

                String sdata = s1 + " " + s2;

                Toast.makeText(getApplicationContext(), "Response "+sdata,Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Successful!",Toast.LENGTH_SHORT).show();
                    successDialog();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"not working!",Toast.LENGTH_SHORT).show();
                failureDialog();
            }
        });
    }


    private void failureDialog() {
        final Dialog dialog = new Dialog(SubmitActivity.this);
        dialog.setContentView(R.layout.not_submitted);
        dialog.show();

    }

    private void successDialog() {
        final Dialog dialog = new Dialog(SubmitActivity.this);
        dialog.setContentView(R.layout.submitted);
        dialog.show();
    }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
        }

        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return  true;
        }



}