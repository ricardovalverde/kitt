package com.example.kitt.model;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kitt.R;
import com.example.kitt.activity.MainActivity;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class MarcaItem extends Item<ViewHolder> {


    @SerializedName("icon_url")
    private final String icon_url;
    @SerializedName("name")
    private final String names;


    public MarcaItem(String icon_url, String names) {
        this.icon_url = icon_url;
        this.names = names;

    }


    public String getNames() {
        return names;
    }


    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ImageView imageView = viewHolder.itemView.findViewById(R.id.logo);
        Picasso.get().load(icon_url).into(imageView);




    }



    @Override
    public int getLayout() {
        return R.layout.marcas_item;
    }
}
