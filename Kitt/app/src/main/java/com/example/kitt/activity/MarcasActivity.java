package com.example.kitt.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.LogoRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.presentation.BrandPresenter;
import com.xwray.groupie.GroupAdapter;

import java.util.List;

public class MarcasActivity extends AppCompatActivity {

    public static String value = null;
    public static String marca = null;
    GroupAdapter adapter = new GroupAdapter();
    private String change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcas_layout);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarcas);
        ImageView arrowBack = findViewById(R.id.backArrowMarcas);
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }


        recyclerView.setAdapter(adapter);

        LogoRemote logoRemote = new LogoRemote();

        if (getIntent().getExtras() != null) {
            change = getIntent().getExtras().getString(value);

            if (change.equals("1")) {
                new BrandPresenter(logoRemote, this).requestAllCarLogo();
            }

        }


        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(MarcasActivity.this, VeiculoActivity.class);
            marca = ((MarcaItem) item).getNames();
            intent.putExtra(VeiculoActivity.MARCA, marca);
            startActivity(intent);


        });


        arrowBack.setOnClickListener(v -> {
            finish();
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
        ProgressBar progressBar = findViewById(R.id.progressBarMarcas);
        progressBar.setVisibility(View.GONE);


    }
}

