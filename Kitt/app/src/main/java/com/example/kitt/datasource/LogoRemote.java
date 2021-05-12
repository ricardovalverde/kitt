package com.example.kitt.datasource;

import com.example.kitt.model.MarcaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoRemote {

    public void findAllLogoCar(CallListLogoDataSource callback) {
        HTTPClient.retrofit().create(KittAPI.class).findAllLogoCar().enqueue(new Callback<List<MarcaItem>>() {
            @Override
            public void onResponse(Call<List<MarcaItem>> call, Response<List<MarcaItem>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
                callback.onComplete();
            }

            @Override
            public void onFailure(Call<List<MarcaItem>> call, Throwable t) {
                callback.onError(t.getMessage());
                callback.onComplete();
            }
        });


    }

    public void findAllLogoMoto(CallListLogoDataSource callback) {
        HTTPClient.retrofit().create(KittAPI.class).findAllLogoMoto().enqueue(new Callback<List<MarcaItem>>() {
            @Override
            public void onResponse(Call<List<MarcaItem>> call, Response<List<MarcaItem>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());

                }
                callback.onComplete();
            }

            @Override
            public void onFailure(Call<List<MarcaItem>> call, Throwable t) {
                callback.onError(t.getMessage());
                callback.onComplete();
            }

        });


    }


    public interface CallListLogoDataSource {
        void onSuccess(List<MarcaItem> item);

        void onError(String errorMessage);

        void onComplete();
    }


}
