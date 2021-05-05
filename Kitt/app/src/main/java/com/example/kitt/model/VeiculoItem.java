package com.example.kitt.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kitt.MarcasActivity;
import com.example.kitt.R;
import com.example.kitt.VeiculoActivity;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class VeiculoItem extends Item<ViewHolder> {
    @SerializedName("name")
    private final String name;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("icon_url")
    private final String icon_url;

    @SerializedName("ano")
    private final String ano;



    public VeiculoItem(String name, String desc, String icon_url, String ano) {
        this.name = name;
        this.desc = desc;
        this.icon_url = icon_url;
        this.ano = ano;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getIcon_url() {
        return icon_url;
    }


    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ImageView imageVeiculo = viewHolder.itemView.findViewById(R.id.image_vehicle);
        TextView textName = viewHolder.itemView.findViewById(R.id.name_vehicle);
        TextView textYear = viewHolder.itemView.findViewById(R.id.year_vehicle);

        Picasso.get().load(icon_url).into(imageVeiculo);
        textName.setText(name);
        textYear.setText(ano);


    }

    @Override
    public int getLayout() {
        return R.layout.veiculos_item;
    }
}
