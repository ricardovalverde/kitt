package com.example.kitt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.model.VeiculoItem;
import com.xwray.groupie.GroupAdapter;

import java.util.ArrayList;
import java.util.List;

public class VeiculoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GroupAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.veiculos_layout);
        recyclerView = findViewById(R.id.recyclerViewVehicle);
        adapter = new GroupAdapter();


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

}
