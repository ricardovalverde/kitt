package com.example.kitt.datasource;

import com.example.kitt.model.Noticias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RevistasRemote {
    public void findAllRevistas(CallListRevistasDatasource revistasDatasource){
        HTTPClient.retrofit().create(KittAPI.class).findAllRevistas().enqueue(new Callback<List<Noticias>>() {
            @Override
            public void onResponse(Call<List<Noticias>> call, Response<List<Noticias>> response) {
                if(response.isSuccessful()){
                    revistasDatasource.onSucces(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Noticias>> call, Throwable t) {
                revistasDatasource.onError(t.getMessage());
            }
        });
    }



    public interface CallListRevistasDatasource{
        void onSucces(List<Noticias> response);
        void onError(String errorMessage);
        void onComplete();


    }
}
