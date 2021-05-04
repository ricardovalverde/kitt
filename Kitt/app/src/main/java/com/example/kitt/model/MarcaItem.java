package com.example.kitt.model;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class MarcaItem extends Item<ViewHolder> {

    


    @SerializedName("icon_url")
    private final String icon_url;
    



    public MarcaItem(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIcon_url() {
        return icon_url;
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
