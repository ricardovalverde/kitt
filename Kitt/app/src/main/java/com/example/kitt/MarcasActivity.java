package com.example.kitt;

import android.graphics.drawable.Drawable;
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
    private GroupAdapter adapter;
    private RecyclerView recyclerView;







    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcaslayout);
        recyclerView = findViewById(R.id.recyclerViewMarcas);

        adapter = new GroupAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.audilogo, null);
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.bmwlogo, null);
        Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.mercedeslogo, null);
        Drawable drawable4 = ResourcesCompat.getDrawable(getResources(), R.drawable.jaguarlogo, null);




        List<MarcaItem> item = new ArrayList<>();
        item.add(new MarcaItem(drawable));
        item.add(new MarcaItem(drawable2));
        item.add(new MarcaItem(drawable3));
        item.add(new MarcaItem(drawable4));

        adapter.addAll(item);
        adapter.notifyDataSetChanged();





    }

}
