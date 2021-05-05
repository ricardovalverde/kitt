package com.example.kitt.datasource;

import com.example.kitt.model.MarcaItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KittAPI {
    String BASE_URL = Endpoint.BASE_URL;



    @GET("marcas_carros/")
    Call<List<MarcaItem>> findAllLogo();


}

