package com.example.kitt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kitt.model.MarcaItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textCarros = findViewById(R.id.carros);
        TextView textMotos = findViewById(R.id.motos);

        textCarros.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcaItem.class);
            intent.putExtra(MarcasActivity.click, "1");


        });
        textMotos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcaItem.class);
            intent.putExtra(MarcasActivity.click, "2");
        });


    }
}
