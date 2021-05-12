package com.example.kitt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitt.R;
import com.example.kitt.datasource.RevistasRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.model.Noticias;
import com.example.kitt.presentation.RevistasPresenter;
import com.xwray.groupie.GroupAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GroupAdapter adapter = new GroupAdapter();
    LinearLayoutManager linearLayout;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewNoticias);


         linearLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
         recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
             @Override
             public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                 imageView1 = findViewById(R.id.arrowRigth);
                 int lastItemScroll = linearLayout.findLastCompletelyVisibleItemPosition();
                 int lastItemList = linearLayout.getItemCount();
                 if(lastItemScroll == (lastItemList-1)){

                     imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_baseline_keyboard_arrow_left_24,null));
                 }
                 else {
                     imageView1.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_baseline_chevron_right_24,null));

                 }



             }
         });


        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);






        TextView Carros = findViewById(R.id.carros);
        TextView Motos = findViewById(R.id.motos);

        Carros.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcasActivity.class);
            intent.putExtra(MarcasActivity.value, "1");
            startActivity(intent);


        });
        Motos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MarcasActivity.class);
            intent.putExtra(MarcasActivity.value, "2");
            startActivity(intent);
        });

        RevistasRemote revistasRemote = new RevistasRemote();
        new RevistasPresenter(revistasRemote, this).requestAllRevistas();


        adapter.setOnItemClickListener((item, view) -> {

            Intent intent = new Intent(MainActivity.this, NoticiasActivity.class);
            intent.putExtra(NoticiasActivity.URL, ((Noticias) item).getUrl());
            startActivity(intent);



        });




    }

    public void showRevistas(List<Noticias> list) {

        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }




    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
    /*public void hideProgress(){
        ProgressBar progressBar = findViewById(R.id.progressBarRevistas);
        progressBar.setVisibility(View.GONE);

    }*/




}
