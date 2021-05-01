package com.example.kitt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.carros);
        txt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcasActivity.class);
            startActivity(intent);
        });


    }
}