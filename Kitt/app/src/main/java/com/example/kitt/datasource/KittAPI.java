package com.example.kitt.datasource;

import com.example.kitt.model.MarcaItem;
import com.example.kitt.model.VeiculoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KittAPI {
    String BASE_URL = Endpoint.BASE_URL;


    @GET("marcas_carros/")
    Call<List<MarcaItem>> findAllLogo();

    @GET("{marca}")
    Call<List<VeiculoItem>> findAllVeiculos(@Path("marca") String marca);


}

