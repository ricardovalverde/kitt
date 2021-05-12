package com.example.kitt.presentation;

import com.example.kitt.activity.MarcasActivity;
import com.example.kitt.datasource.LogoRemote;
import com.example.kitt.model.MarcaItem;

import java.util.List;

public class BrandPresenter implements LogoRemote.CallListLogoDataSource {


    private final LogoRemote logoRemote;
    private final MarcasActivity view;

    public BrandPresenter(LogoRemote logoRemote, MarcasActivity view) {
        this.logoRemote = logoRemote;
        this.view = view;
    }

    public void requestAllCarLogo() {
        this.logoRemote.findAllLogoCar(this);
    }

    public void requestAllMotoLogo() {
        this.logoRemote.findAllLogoMoto(this);
    }


    @Override
    public void onSuccess(List<MarcaItem> item) {
        view.showMarcas(item);


    }

    @Override
    public void onError(String errorMessage) {
        this.view.showError(errorMessage);
    }

    @Override
    public void onComplete() {
        this.view.hideProgressBar();
    }
}
