package com.example.kitt.datasource;

import com.example.kitt.model.NewsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRemote {
    public void findAllCarMagazines(CallListRevistasDatasource magazinesDataSource) {

        HTTPClient.retrofit().create(KittAPI.class).findAllNewsCar().enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                if (response.isSuccessful()) {
                    magazinesDataSource.onSuccesCar(response.body());
                }
                magazinesDataSource.onCompleteCar();
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                magazinesDataSource.onErrorCar(t.getMessage());
                magazinesDataSource.onCompleteCar();
            }
        });
    }

    public void findAllMotorcycleMagazines(CallListRevistasDatasource magazinesDataSource) {

        HTTPClient.retrofit().create(KittAPI.class).findAllNewsMoto().enqueue(new Callback<List<NewsItem>>() {
            @Override
            public void onResponse(Call<List<NewsItem>> call, Response<List<NewsItem>> response) {
                if (response.isSuccessful()) {
                    magazinesDataSource.onSuccesMoto(response.body());
                }
                magazinesDataSource.onCompleteMoto();
            }

            @Override
            public void onFailure(Call<List<NewsItem>> call, Throwable t) {
                magazinesDataSource.onErrorMoto(t.getMessage());
                magazinesDataSource.onCompleteMoto();
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
