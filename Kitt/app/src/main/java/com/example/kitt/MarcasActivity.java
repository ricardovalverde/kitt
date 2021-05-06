package com.example.kitt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.datasource.LogoRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.presentation.BrandPresenter;
import com.xwray.groupie.GroupAdapter;

import java.util.List;

public class MarcasActivity extends AppCompatActivity {

    public static final String click = null;
    public static String marca = null;
    GroupAdapter adapter = new GroupAdapter();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcas_layout);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarcas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        LogoRemote logoRemote = new LogoRemote();
        new BrandPresenter(logoRemote, this).requestAllLogos();

        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(MarcasActivity.this, VeiculoActivity.class);
            marca = ((MarcaItem) item).getNames();
            intent.putExtra(VeiculoActivity.MARCA, marca);
            startActivity(intent);


        });


    }

    public void showMarcas(List<MarcaItem> marcaItems) {


        adapter.addAll(marcaItems);
        adapter.notifyDataSetChanged();


    }

    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }

    public void hideProgressBar() {
        progressBar = findViewById(R.id.progressBarMarcas);
        progressBar.setVisibility(View.GONE);


    }
}

