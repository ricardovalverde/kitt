package com.example.kitt;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVeiculos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if (getIntent().getExtras() != null) {

            String marca = getIntent().getExtras().getString(MARCA);
            VeiculoRemote veiculoRemote = new VeiculoRemote();
            VeiculoPresenter veiculoPresenter = new VeiculoPresenter(veiculoRemote, this);
            veiculoPresenter.requestVeiculos(marca);
        }


    }

    public void showVeiculos(List<VeiculoItem> veiculoItem) {
        TextView textView = findViewById(R.id.marca_vehicle);

        String marca = getIntent().getExtras().getString(MARCA);
        if(!marca.equals("bmw")){
            String cap = marca.substring(0, 1).toUpperCase() + marca.substring(1);
            textView.setText(cap);
        }
        else {
            textView.setText(marca.toUpperCase());
        }




        adapter.addAll(veiculoItem);
        adapter.notifyDataSetChanged();


    }

}
