package com.example.mizyner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME_OUT = 1000;
        new Handler().postDelayed(() -> {
            Intent SplashActivity2=new Intent(SplashActivity.this,SplashActivity2.class);
            startActivity(SplashActivity2);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
