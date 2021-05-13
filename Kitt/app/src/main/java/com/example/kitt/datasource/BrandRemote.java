package com.example.kitt.datasource;

import com.example.kitt.model.BrandItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandRemote {

    public void findAllLogoCar(CallListLogoDataSource callback) {

        HTTPClient.retrofit().create(KittAPI.class).findAllBrandCar().enqueue(new Callback<List<BrandItem>>() {
            @Override
            public void onResponse(Call<List<BrandItem>> call, Response<List<BrandItem>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
                callback.onComplete();
            }

            @Override
            public void onFailure(Call<List<BrandItem>> call, Throwable t) {
                callback.onError(t.getMessage());
                callback.onComplete();
            }
        });
    }

    public void findAllLogoMoto(CallListLogoDataSource callback) {

        HTTPClient.retrofit().create(KittAPI.class).findAllBrandMoto().enqueue(new Callback<List<BrandItem>>() {
            @Override
            public void onResponse(Call<List<BrandItem>> call, Response<List<BrandItem>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());

                }
                callback.onComplete();
            }

            @Override
            public void onFailure(Call<List<BrandItem>> call, Throwable t) {
                callback.onError(t.getMessage());
                callback.onComplete();
            }

        });
    }


    public interface CallListLogoDataSource {

        void onSuccess(List<BrandItem> item);

        void onError(String errorMessage);

        void onComplete();
    }
}
