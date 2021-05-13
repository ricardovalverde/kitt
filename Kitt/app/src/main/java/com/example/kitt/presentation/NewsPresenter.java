package com.example.kitt.presentation;

import com.example.kitt.activity.FragmentCarActivity;
import com.example.kitt.activity.FragmentMotoActivity;
import com.example.kitt.datasource.NewsRemote;
import com.example.kitt.model.NewsItem;

import java.util.List;

public class NewsPresenter implements NewsRemote.CallListRevistasDatasource {

    private final NewsRemote revistasRemote;
    private FragmentCarActivity viewCar = null;
    private FragmentMotoActivity viewMoto = null;


    public NewsPresenter(NewsRemote newsRemote, FragmentCarActivity view) {
        this.revistasRemote = newsRemote;
        this.viewCar = view;
    }

    public NewsPresenter(NewsRemote newsRemote, FragmentMotoActivity view) {
        this.revistasRemote = newsRemote;
        this.viewMoto = view;
    }


    public void requestAllRevistasCarros() {
        this.revistasRemote.findAllRevistasCarros(this);
    }

    public void requestAllRevistasMotos() {
        this.revistasRemote.findAllRevistasMotos(this);
    }


    @Override
    public void onSuccesCar(List<NewsItem> response) {
        viewCar.showRevistas(response);
    }

    @Override
    public void onSuccesMoto(List<NewsItem> response) {
        viewMoto.showRevistas(response);
    }

    @Override
    public void onErrorCar(String errorMessage) {
        viewCar.showError(errorMessage);
    }

    @Override
    public void onErrorMoto(String errorMessage) {
        viewMoto.showError(errorMessage);
    }

    @Override
    public void onCompleteCar() {
        viewCar.hideProgressBar();
    }

    @Override
    public void onCompleteMoto() {
        viewMoto.hideProgressBar();
    }
}
