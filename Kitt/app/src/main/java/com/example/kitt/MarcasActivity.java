package com.example.kitt;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.datasource.LogoRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.presentation.BrandPresenter;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.GroupAdapter;

import java.util.ArrayList;
import java.util.List;

public class MarcasActivity extends AppCompatActivity {

    public static final String click = null;
    GroupAdapter adapter = new GroupAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcas_layout);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMarcas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LogoRemote logoRemote = new LogoRemote();
        new BrandPresenter(logoRemote,this).requestAllLogos();


    }

    public void showMarcas(List<String> marcaItems) {
        /*if (getIntent().getExtras() != null) {

            String onclick = getIntent().getExtras().getString(click);

            if (onclick.equals("carros")) {

                List<MarcaItem> items = new ArrayList<>();
                adapter.addAll(items);
                adapter.notifyDataSetChanged();


            } else {

                List<MarcaItem> items = new ArrayList<>();
                adapter.addAll(items);
                adapter.notifyDataSetChanged();
            }


        }


    }*/

        List<MarcaItem> items = new ArrayList<>();

        for (String marcaItem : marcaItems){
           items.add(new MarcaItem(marcaItem));
        }
        adapter.addAll(items);
        adapter.notifyDataSetChanged();






    }

    public void showError(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();



    }
}

