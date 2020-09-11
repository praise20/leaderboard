package com.example.leaderboard;

import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends Activity {


    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
