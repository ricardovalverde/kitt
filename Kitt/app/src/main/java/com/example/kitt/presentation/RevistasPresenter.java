package com.example.kitt.presentation;

import com.example.kitt.activity.MainActivity;
import com.example.kitt.datasource.RevistasRemote;
import com.example.kitt.model.MarcaItem;
import com.example.kitt.model.Noticias;

import java.util.List;

public class RevistasPresenter implements RevistasRemote.CallListRevistasDatasource {
    private final RevistasRemote revistasRemote;
    private final MainActivity view;

    public RevistasPresenter(RevistasRemote revistasRemote, MainActivity view) {
        this.revistasRemote = revistasRemote;
        this.view = view;
    }


    public void requestAllRevistas() {
        this.revistasRemote.findAllRevistas(this);
    }


    @Override
    public void onSucces(List<Noticias> response) {
        view.showRevistas(response);
    }

    @Override
    public void onError(String errorMessage) {
        view.showError(errorMessage);
    }

    @Override
    public void onComplete() {
        //view.hideProgress();
    }
}
