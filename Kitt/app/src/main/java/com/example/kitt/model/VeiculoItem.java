package com.example.kitt.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class VeiculoItem extends Item<ViewHolder> {
    private final Drawable drawable;
    private final String name, year,desc;

    public VeiculoItem(Drawable drawable, String name, String year, String desc) {
        this.drawable = drawable;
        this.name = name;
        this.year = year;
        this.desc = desc;
    }


    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ImageView imageView = viewHolder.itemView.findViewById(R.id.image_vehicle);
        TextView textName = viewHolder.itemView.findViewById(R.id.name_vehicle);
        TextView textYear = viewHolder.itemView.findViewById(R.id.year_vehicle);
        TextView textDesc = viewHolder.itemView.findViewById(R.id.txt_desc_veiculo);

        imageView.setImageDrawable(drawable);
        textName.setText(name);
        textYear.setText(year);
        textDesc.setText(desc);

    }

    @Override
    public int getLayout() {
        return R.layout.veiculos_item;
    }
}
