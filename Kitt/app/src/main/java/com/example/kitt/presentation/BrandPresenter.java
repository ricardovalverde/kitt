package com.example.kitt.presentation;

import com.example.kitt.MarcasActivity;
import com.example.kitt.datasource.LogoRemote;
import com.example.kitt.model.MarcaItem;

import java.util.ArrayList;
import java.util.List;

public class BrandPresenter implements LogoRemote.CallListLogoDataSource{


    public BrandPresenter(LogoRemote logoRemote, MarcasActivity view) {
        this.logoRemote = logoRemote;
        this.view = view;
    }

    private final LogoRemote logoRemote;
    private final MarcasActivity view;



    public void requestAllLogos(){
    this.logoRemote.findAllLogo(this);
    }


    @Override
    public void onSuccess(List<MarcaItem> item) {
        view.showMarcas(item);



    }

    @Override
    public void onError(String errorMessage) {
        this.view.showError(errorMessage);
    }
}
