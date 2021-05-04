package com.example.kitt.datasource;

import com.example.kitt.model.MarcaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoRemote {

    public interface CallListLogoDataSource {
        void onSuccess(List<MarcaItem> item);
        void onError(String errorMessage);
    }


    public void findAllLogo(CallListLogoDataSource callback) {
        HTTPClient.retrofit().create(KittAPI.class).findAllLogo().enqueue(new Callback<List<MarcaItem>>() {
            @Override
            public void onResponse(Call<List<MarcaItem>> call, Response<List<MarcaItem>> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<MarcaItem>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });






    }


}
