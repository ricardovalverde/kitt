package com.example.kitt;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.kitt.datasource.DetalhesRemote;
import com.example.kitt.presentation.DetalhesPresenter;

import java.util.ArrayList;
import java.util.List;

public class DetalhesVeiculosActivity extends AppCompatActivity {
    static final String DESCRICAO = "descricao";
    static final String ID = "1";
    static final String NAME = "name";
    static final String ANO = "ano";
    private String descricao;
    private String name;
    private String ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos_detalhes);


        if (getIntent().getExtras() != null) {
            descricao = getIntent().getExtras().getString(DESCRICAO);
            String id = getIntent().getExtras().getString(ID);
            name = getIntent().getExtras().getString(NAME);
            ano = getIntent().getExtras().getString(ANO);


            DetalhesRemote detalhesRemote = new DetalhesRemote();
            new DetalhesPresenter(detalhesRemote, this).requestDetails(id);

        }


    }

    public void showDetails(List<String> list) {
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        for (String item : list) {
            slideModels.add(new SlideModel(item, (name + " " + ano), ScaleTypes.CENTER_CROP));

        }
        imageSlider.setImageList(slideModels, null);
        if (getIntent().getExtras() != null) {
            TextView textDescricao = findViewById(R.id.txt_desc_veiculo);
            textDescricao.setText(descricao);
        }


    }

}