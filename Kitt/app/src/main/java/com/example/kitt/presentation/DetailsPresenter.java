package com.example.kitt.presentation;

import com.example.kitt.activity.VehicleDetailsActivity;
import com.example.kitt.datasource.DetailsRemote;

import java.util.List;

public class DetailsPresenter implements DetailsRemote.CallVeiculosDetalhes {

    private final DetailsRemote call;
    private final VehicleDetailsActivity view;

    public DetailsPresenter(DetailsRemote call, VehicleDetailsActivity view) {
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
        view.showError(errorMessage);
    }

    @Override
    public void onComplete() {
        this.view.hideProgressBar();
    }
}
