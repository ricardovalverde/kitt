package com.example.kitt.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.kitt.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class NewsItem extends Item<ViewHolder> {

    @SerializedName("icon_url")
    private final String icon_url;

    @SerializedName("url")
    private final String url;

    public NewsItem(String icon_url, String url) {
        this.icon_url = icon_url;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {
        ImageView imageView = viewHolder.itemView.findViewById(R.id.noticiasImage);
        Picasso.get().load(icon_url).into(imageView);
    }

    @Override
    public int getLayout() {
        return R.layout.news_item;
    }
}
