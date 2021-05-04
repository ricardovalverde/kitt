package com.example.kitt.datasource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogoRemote {

    public interface CallListLogoDataSource {
        void onSuccess(List<String> response);
        void onError(String errorMessage);
    }


    public void findAllLogo(CallListLogoDataSource callback) {
        HTTPClient.retrofit().create(KittAPI.class)
                .findAllLogo()
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        if(response.isSuccessful()){
                            callback.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });



    }


}
