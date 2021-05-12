package com.example.kitt.datasource;

import com.example.kitt.model.MarcaItem;
import com.example.kitt.model.Noticias;
import com.example.kitt.model.VeiculoItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KittAPI {
    String BASE_URL = Endpoint.BASE_URL;


    @GET("marcas_carros/")
    Call<List<MarcaItem>> findAllLogoCar();

    @GET("marcas_motos/")
    Call<List<MarcaItem>> findAllLogoMoto();

    @GET("revistas/")
    Call<List<Noticias>> findAllRevistas();


    @GET("{marca}")
    Call<List<VeiculoItem>> findAllVeiculos(@Path("marca") String marca);

    @GET("{id}")
    Call<List<String>> findDetailsVehicles(@Path("id") String id);


}


