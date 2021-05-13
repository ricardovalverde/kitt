package com.example.kitt.datasource;

import com.example.kitt.model.NewsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRemote {
    public void findAllRevistasCarros(CallListRevistasDatasource revistasDatasource) {

        HTTPClient.retrofit().create(KittAPI.class).findAllRevistasCarros().enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                if (response.isSuccessful()) {
                    revistasDatasource.onSuccesCar(response.body());
                }
                revistasDatasource.onCompleteCar();
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                revistasDatasource.onErrorCar(t.getMessage());
                revistasDatasource.onCompleteCar();
            }
        });
    }

    public void findAllRevistasMotos(CallListRevistasDatasource revistasDatasource) {

        HTTPClient.retrofit().create(KittAPI.class).findAllRevistasMoto().enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                if (response.isSuccessful()) {
                    revistasDatasource.onSuccesMoto(response.body());
                }
                revistasDatasource.onCompleteMoto();
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                revistasDatasource.onErrorMoto(t.getMessage());
                revistasDatasource.onCompleteMoto();
            }
        });
    }


    public interface CallListRevistasDatasource {
        void onSuccesCar(List<NewsItem> response);

        void onSuccesMoto(List<NewsItem> response);

        void onErrorCar(String errorMessage);

        void onErrorMoto(String errorMessage);

        void onCompleteCar();

        void onCompleteMoto();

    }
}
