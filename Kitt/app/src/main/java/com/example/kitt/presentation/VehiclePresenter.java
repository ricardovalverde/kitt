package com.example.kitt.presentation;

import com.example.kitt.activity.VehicleActivity;
import com.example.kitt.datasource.VehicleRemote;
import com.example.kitt.model.VehicleItem;

import java.util.List;

public class VehiclePresenter implements VehicleRemote.CallListVeiculoDataRemote {

    private final VehicleRemote veiculoRemote;
    private final VehicleActivity view;

    public VehiclePresenter(VehicleRemote veiculoRemote, VehicleActivity view) {
        this.veiculoRemote = veiculoRemote;
        this.view = view;
    }

    public void requestVeiculos(String marca) {
        this.veiculoRemote.findAllVeiculos(this, marca);
    }


    @Override
    public void onSuccess(List<VehicleItem> veiculoItemList) {
        view.showVeiculos(veiculoItemList);
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
