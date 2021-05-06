package com.example.kitt.presentation;

import com.example.kitt.DetalhesVeiculosActivity;
import com.example.kitt.datasource.DetalhesRemote;

import java.util.List;

public class DetalhesPresenter implements DetalhesRemote.CallVeiculosDetalhes {

    private final DetalhesRemote call;
    private final DetalhesVeiculosActivity view;

    public DetalhesPresenter(DetalhesRemote call, DetalhesVeiculosActivity view) {
        this.call = call;
        this.view = view;
    }

    public void requestDetails(String id) {
        this.call.findDetailsVehicles(this, id);
    }

    @Override
    public void onSuccess(List<String> response) {
        view.showDetails(response);
    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onComplete() {
        this.view.hideProgressBar();
    }
}
