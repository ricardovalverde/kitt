package com.example.kitt.datasource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesRemote {
    public void findDetailsVehicles(CallVeiculosDetalhes callback, String id) {
        HTTPClient.retrofit().create(KittAPI.class)
                .findDetailsVehicles(id)
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        if (response.isSuccessful()) {
                            callback.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });


    }


    public interface CallVeiculosDetalhes {
        void onSuccess(List<String> response);

        void onError(String errorMessage);
    }
}



