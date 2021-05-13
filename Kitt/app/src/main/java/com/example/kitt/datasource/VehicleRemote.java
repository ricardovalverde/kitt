package com.example.kitt.datasource;

import com.example.kitt.model.VehicleItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleRemote {
    public void findAllVeiculos(CallListVeiculoDataRemote callback, String marca) {

        HTTPClient.retrofit().create(KittAPI.class)
                .findAllVeiculos(marca)
                .enqueue(new Callback<List<VehicleItem>>() {
                    @Override
                    public void onResponse(Call<List<VehicleItem>> call, Response<List<VehicleItem>> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess(response.body());
                        }
                        callback.onComplete();
                    }

                    @Override
                    public void onFailure(Call<List<VehicleItem>> call, Throwable t) {
                        callback.onError(t.getMessage());
                        callback.onComplete();

                    }

                });


    }

    public interface CallListVeiculoDataRemote {
        void onSuccess(List<VehicleItem> veiculoItemList);

        void onError(String errorMessage);

        void onComplete();
    }
}
