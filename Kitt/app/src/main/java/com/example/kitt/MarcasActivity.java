package com.example.kitt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.model.MarcaItem;
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
        showMarcas();


    }

    private void showMarcas() {
        if (getIntent().getExtras() != null) {

            String onclick = getIntent().getExtras().getString(click);

            if (onclick.equals("carros")) {

                List<MarcaItem> items = new ArrayList<>();
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.audilogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.jaguarlogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.mercedeslogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.bmwlogo, null), "audi"));
                adapter.addAll(items);
                adapter.notifyDataSetChanged();


            } else if (onclick.equals("motos")) {

                List<MarcaItem> items = new ArrayList<>();
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.yamahalogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.ducatilogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.harleydavidsonlogo, null), "audi"));
                items.add(new MarcaItem(ResourcesCompat.getDrawable(getResources(), R.drawable.hondalogo, null), "audi"));
                adapter.addAll(items);
                adapter.notifyDataSetChanged();
            }


        }


    }


}


