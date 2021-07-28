package com.example.kitt.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class VehicleItem extends Item<ViewHolder> {

    @SerializedName("name")
    private final String name;

    @SerializedName("desc")
    private final String desc;

    @SerializedName("icon_url")
    private final String icon_url;

    @SerializedName("ano")
    private final String ano;

    @SerializedName("ident")
    private final String ident;


    public VehicleItem(String name, String desc, String icon_url, String ano, String ident) {
        this.name = name;
        this.desc = desc;
        this.icon_url = icon_url;
        this.ano = ano;
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }

    public String getName() {
        return name;
    }

    public String getAno() {
        return ano;
    }

    public String getDesc() {
        return desc;
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
        return R.layout.vehicles_item;
    }
}
