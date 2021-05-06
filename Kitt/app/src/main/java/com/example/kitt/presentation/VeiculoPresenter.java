package com.example.kitt.presentation;

import com.example.kitt.activity.VeiculoActivity;
import com.example.kitt.datasource.VeiculoRemote;
import com.example.kitt.model.VeiculoItem;

import java.util.List;

public class VeiculoPresenter implements VeiculoRemote.CallListVeiculoDataRemote {

    private final VeiculoRemote veiculoRemote;
    private final VeiculoActivity view;

    public VeiculoPresenter(VeiculoRemote veiculoRemote, VeiculoActivity view) {
        this.veiculoRemote = veiculoRemote;
        this.view = view;
    }

    public void requestVeiculos(String marca) {

        this.veiculoRemote.findAllVeiculos(this, marca);
    }


    @Override
    public void onSuccess(List<VeiculoItem> veiculoItemList) {
        view.showVeiculos(veiculoItemList);
    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onComplete() {
        this.view.hideProgressBar();
    }
}
