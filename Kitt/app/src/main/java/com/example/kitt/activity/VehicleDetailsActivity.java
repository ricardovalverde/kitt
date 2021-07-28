package com.example.kitt.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.kitt.R;
import com.example.kitt.datasource.DetailsRemote;
import com.example.kitt.presentation.DetailsPresenter;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetailsActivity extends AppCompatActivity {

    static final String DESCRIPTION = "descricao";
    static final String ID = "1";
    static final String NAME = "name";
    static final String YEAR = "ano";

    private ProgressBar progressBar;
    private String descricao;
    private String name;
    private String year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        callDetailsRemote();
        arrowBackClick();
    }

    public void showDetails(List<String> list) {
        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        for (String item : list) {
            slideModels.add(new SlideModel(item, (name + " " + year), ScaleTypes.CENTER_CROP));
        }

        imageSlider.setImageList(slideModels, null);

        if (getIntent().getExtras() != null) {
            TextView textDescricao = findViewById(R.id.txt_desc_veiculo);
            textDescricao.setText(descricao);
        }
    }

    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void hideProgressBar() {
        progressBar = findViewById(R.id.progressBarDetalhes);
        progressBar.setVisibility(View.GONE);
    }

    private void arrowBackClick() {
        ImageView arrowBack = findViewById(R.id.arrowBackDetails);
        arrowBack.setOnClickListener(v -> {
            finish();
        });

    }

    private void callDetailsRemote() {

        if (getIntent().getExtras() != null) {
            descricao = getIntent().getExtras().getString(DESCRIPTION);
            String id = getIntent().getExtras().getString(ID);
            name = getIntent().getExtras().getString(NAME);
            year = getIntent().getExtras().getString(YEAR);

            DetailsRemote detailsRemote = new DetailsRemote();
            new DetailsPresenter(detailsRemote, this).requestDetails(id);

        }
    }
}