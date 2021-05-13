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
import com.example.kitt.datasource.BrandRemote;
import com.example.kitt.model.BrandItem;
import com.example.kitt.presentation.BrandPresenter;
import com.xwray.groupie.GroupAdapter;

import java.util.List;

public class BrandsActivity extends AppCompatActivity {

    public static String value = null;
    public static String marca = null;
    private final GroupAdapter adapter = new GroupAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brand_layout);

        configurationRecyclerView();
        callBrandRemote();
        adapterClick();
        arrowBackClick();
    }


    public void showMarcas(List<BrandItem> marcaItems) {


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

    private void arrowBackClick() {
        ImageView arrowBack = findViewById(R.id.backArrowMarcas);
        arrowBack.setOnClickListener(v -> {
            finish();
        });


    }

    private void configurationRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarcas);
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }
        recyclerView.setAdapter(adapter);
    }

    private void adapterClick() {
        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(BrandsActivity.this, VehicleActivity.class);
            marca = ((BrandItem) item).getNames();
            intent.putExtra(VehicleActivity.MARCA, marca);
            startActivity(intent);


        });
    }

    private void callBrandRemote() {

        BrandRemote logoRemote = new BrandRemote();

        if (getIntent().getExtras() != null) {
            String type = getIntent().getExtras().getString(value);

            if (type.equals("1")) {
                new BrandPresenter(logoRemote, this).requestAllCarLogo();
            } else {
                new BrandPresenter(logoRemote, this).requestAllMotoLogo();
            }
        }
    }

}

