package com.example.kitt.presentation;

import com.example.kitt.activity.CarFragmentActivity;
import com.example.kitt.activity.MotoFragmentActivity;
import com.example.kitt.datasource.RevistasRemote;
import com.example.kitt.model.Noticias;

import java.util.List;

public class RevistasPresenter implements RevistasRemote.CallListRevistasDatasource {
    private final RevistasRemote revistasRemote;
    private CarFragmentActivity viewCar = null;
    private MotoFragmentActivity viewMoto = null;


    public RevistasPresenter(RevistasRemote revistasRemote, CarFragmentActivity view) {
        this.revistasRemote = revistasRemote;
        this.viewCar = view;
    }

    public RevistasPresenter(RevistasRemote revistasRemote, MotoFragmentActivity view) {
        this.revistasRemote = revistasRemote;
        this.viewMoto = view;
    }


    public void requestAllRevistasCarros() {
        this.revistasRemote.findAllRevistasCarros(this);
    }

    public void requestAllRevistasMotos() {
        this.revistasRemote.findAllRevistasMotos(this);
    }


    @Override
    public void onSuccesCar(List<Noticias> response) {
        viewCar.showRevistas(response);
    }

    @Override
    public void onSuccesMoto(List<Noticias> response) {
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
