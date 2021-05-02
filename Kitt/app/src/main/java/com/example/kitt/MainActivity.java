package com.example.kitt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick();


    }

    private void onClick() {

        TextView txtCarro = findViewById(R.id.carros);
        TextView txtMoto = findViewById(R.id.motos);

        txtCarro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcasActivity.class);
            intent.putExtra(MarcasActivity.click, "carros");
            startActivity(intent);
        });
        txtMoto.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcasActivity.class);
            intent.putExtra(MarcasActivity.click, "motos");
            startActivity(intent);
        });

    }


}