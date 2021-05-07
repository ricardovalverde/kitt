package com.example.kitt.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.kitt.R;

public class NoticiasActivity extends AppCompatActivity {
    static final String URL= "url";
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticias_layout);

        if(getIntent().getExtras() != null){
             url = getIntent().getExtras().getString(URL);

        }
        WebView webView= (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}