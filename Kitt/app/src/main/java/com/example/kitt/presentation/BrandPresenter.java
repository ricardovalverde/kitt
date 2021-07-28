package com.example.kitt.presentation;

import com.example.kitt.activity.BrandsActivity;
import com.example.kitt.datasource.BrandRemote;
import com.example.kitt.model.BrandItem;

import java.util.List;

public class BrandPresenter implements BrandRemote.CallListLogoDataSource {

    private final BrandRemote logoRemote;
    private final BrandsActivity view;

    public BrandPresenter(BrandRemote logoRemote, BrandsActivity view) {
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
    public void onSuccess(List<BrandItem> item) {
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
