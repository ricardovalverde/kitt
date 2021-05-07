package com.example.kitt.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.RevistasRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.model.Noticias;
import com.example.kitt.presentation.RevistasPresenter;
import com.xwray.groupie.Group;
import com.xwray.groupie.GroupAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GroupAdapter adapter = new GroupAdapter();
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewNoticias);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

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

        RevistasRemote revistasRemote = new RevistasRemote();
        new RevistasPresenter(revistasRemote,this).requestAllRevistas();

        adapter.setOnItemClickListener((item, view) -> {
            Intent intent = new Intent(MainActivity.this,NoticiasActivity.class);
            intent.putExtra(NoticiasActivity.URL, ((Noticias)item).getUrl());
            startActivity(intent);




        });



    }
    public void showRevistas(List<Noticias> list){
        adapter.addAll(list);
        adapter.notifyDataSetChanged();

    }
    public void showError(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
    /*public void hideProgress(){
        progressBar = findViewById(R.id.progressBarRevistas);
        progressBar.setVisibility(View.GONE);

    }*/
}
