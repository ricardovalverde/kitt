package com.example.kitt.datasource;

import com.example.kitt.model.VeiculoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VeiculoRemote {
    public void findAllVeiculos(CallListVeiculoDataRemote callback, String marca) {
        HTTPClient.retrofit().create(KittAPI.class)
                .findAllVeiculos(marca)
                .enqueue(new Callback<List<VeiculoItem>>() {
                    @Override
                    public void onResponse(Call<List<VeiculoItem>> call, Response<List<VeiculoItem>> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<VeiculoItem>> call, Throwable t) {
                        callback.onError(t.getMessage());


                    }
                });


    }

    public interface CallListVeiculoDataRemote {
        void onSuccess(List<VeiculoItem> veiculoItemList);

        void onError(String errorMessage);
    }


}
