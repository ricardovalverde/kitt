package com.example.kitt.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class MarcaItem extends Item<ViewHolder> {


    @SerializedName("icon_url")
    private final String icon_url;
    @SerializedName("name")
    private final String names;
    @SerializedName("categoria")
    private final String categoria;

    public String getIcon_url() {
        return icon_url;
    }

    public String getNames() {
        return names;
    }

    public String getCategoria() {
        return categoria;
    }


    public MarcaItem(String icon_url, String names, String categoria) {
        this.icon_url = icon_url;
        this.names = names;
        this.categoria = categoria;
    }


    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ImageView imageView = viewHolder.itemView.findViewById(R.id.logo);





    }

    @Override
    public int getLayout() {
        return R.layout.marcas_item;
    }
}
