package com.example.kitt.presentation;

import com.example.kitt.activity.VehicleActivity;
import com.example.kitt.datasource.VehicleRemote;
import com.example.kitt.model.VehicleItem;

import java.util.List;

public class VehiclePresenter implements VehicleRemote.CallListVeiculoDataRemote {

    private final VehicleRemote vehicleRemote;
    private final VehicleActivity view;

    public VehiclePresenter(VehicleRemote vehicleRemote, VehicleActivity view) {
        this.vehicleRemote = vehicleRemote;
        this.view = view;
    }

    public void requestVeiculos(String marca) {
        this.vehicleRemote.findAllVehicles(this, marca);
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
