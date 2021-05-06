package com.example.kitt.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.VeiculoRemote;
import com.example.kitt.model.VeiculoItem;
import com.example.kitt.presentation.VeiculoPresenter;
import com.xwray.groupie.GroupAdapter;

import java.util.List;

public class VeiculoActivity extends AppCompatActivity {
    static final String MARCA = "marca";

    private final GroupAdapter adapter = new GroupAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.veiculos_layout);


        ImageView arrowBack = findViewById(R.id.backArrow);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVeiculos);
        Configuration configuration = getResources().getConfiguration();


        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }

        recyclerView.setAdapter(adapter);

        if (getIntent().getExtras() != null) {

            String marca = getIntent().getExtras().getString(MARCA);
            VeiculoRemote veiculoRemote = new VeiculoRemote();
            VeiculoPresenter veiculoPresenter = new VeiculoPresenter(veiculoRemote, this);
            veiculoPresenter.requestVeiculos(marca);

        }
        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(VeiculoActivity.this, DetalhesVeiculosActivity.class);
            String desc = ((VeiculoItem) item).getDesc();
            String id = ((VeiculoItem) item).getIdent();
            String name = ((VeiculoItem) item).getName();
            String ano = ((VeiculoItem) item).getAno();


            intent.putExtra(DetalhesVeiculosActivity.DESCRICAO, desc);
            intent.putExtra(DetalhesVeiculosActivity.ID, id);
            intent.putExtra(DetalhesVeiculosActivity.NAME, name);
            intent.putExtra(DetalhesVeiculosActivity.ANO, ano);
            startActivity(intent);


        });
        arrowBack.setOnClickListener(v -> {
            finish();

        });


    }

    public void showVeiculos(List<VeiculoItem> veiculoItem) {
        TextView textView = findViewById(R.id.marca_vehicle);

        String marca = getIntent().getExtras().getString(MARCA);
        if (!marca.equals("bmw")) {
            String cap = marca.substring(0, 1).toUpperCase() + marca.substring(1);
            textView.setText(cap);
        } else {
            textView.setText(marca.toUpperCase());
        }

        adapter.addAll(veiculoItem);
        adapter.notifyDataSetChanged();


    }

    public void hideProgressBar() {
        ProgressBar progressBar = findViewById(R.id.progressBarVeiculos);
        progressBar.setVisibility(View.GONE);


    }


}
