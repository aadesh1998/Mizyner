package com.example.mizyner;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        int SPLASH_TIME_OUT = 6000;
        new Handler().postDelayed(() -> {
            Intent homeActivity=new Intent(SplashActivity2.this,HomeActivity.class);
            startActivity(homeActivity);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
