package com.example.kitt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kitt.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(Looper.myLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MarcasActivity.class);
            startActivity(intent);
            finish();
        }, 4000);
    }
}