package com.example.kitt.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.VehicleRemote;
import com.example.kitt.model.VehicleItem;
import com.example.kitt.presentation.VehiclePresenter;
import com.xwray.groupie.GroupAdapter;

import java.util.List;

public class VehicleActivity extends AppCompatActivity {

    static final String BRAND = "marca";
    private final GroupAdapter adapter = new GroupAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_layout);

        configurationRecyclerView();
        callVeiculoRemote();
        adapaterClick();
        arrowBackClick();

    }

    public void showVeiculos(List<VehicleItem> veiculoItem) {
        TextView textView = findViewById(R.id.marca_vehicle);

        String brand = getIntent().getExtras().getString(BRAND);
        if (!brand.equals("bmw")) {
            String cap = brand.substring(0, 1).toUpperCase() + brand.substring(1);
            textView.setText(cap);
        } else {
            textView.setText(brand.toUpperCase());
        }

        adapter.addAll(veiculoItem);
        adapter.notifyDataSetChanged();
    }

    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void hideProgressBar() {
        ProgressBar progressBar = findViewById(R.id.progressBarVeiculos);
        progressBar.setVisibility(View.GONE);
    }

    private void arrowBackClick() {
        ImageView arrowBack = findViewById(R.id.backArrow);
        arrowBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void configurationRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVeiculos);
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }

        recyclerView.setAdapter(adapter);
    }

    private void callVeiculoRemote() {

        if (getIntent().getExtras() != null) {

            String brand = getIntent().getExtras().getString(BRAND);
            VehicleRemote vehicleRemote = new VehicleRemote();
            VehiclePresenter vehiclePresenter = new VehiclePresenter(vehicleRemote, this);
            vehiclePresenter.requestVeiculos(brand);
        }
    }

    private void adapaterClick() {
        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(VehicleActivity.this, VehicleDetailsActivity.class);

            String desc = ((VehicleItem) item).getDesc();
            String id = ((VehicleItem) item).getIdent();
            String name = ((VehicleItem) item).getName();
            String year = ((VehicleItem) item).getAno();

            intent.putExtra(VehicleDetailsActivity.DESCRIPTION, desc);
            intent.putExtra(VehicleDetailsActivity.ID, id);
            intent.putExtra(VehicleDetailsActivity.NAME, name);
            intent.putExtra(VehicleDetailsActivity.YEAR, year);

            startActivity(intent);
        });
    }
}
