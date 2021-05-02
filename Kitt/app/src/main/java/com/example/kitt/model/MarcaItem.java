package com.example.kitt.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class MarcaItem extends Item<ViewHolder> {

    private final Drawable drawable;
    private final String name;

    public MarcaItem(Drawable drawable, String name) {
        this.drawable = drawable;
        this.name = name;
    }

    public String getName() {
        return name;
    }




    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {

        ImageView imageView = viewHolder.itemView.findViewById(R.id.logo);
        imageView.setImageDrawable(drawable);


    }

    @Override
    public int getLayout() {
        return R.layout.marcas_item;
    }
}
