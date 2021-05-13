package com.example.kitt.datasource;

import com.example.kitt.model.BrandItem;
import com.example.kitt.model.NewsItem;
import com.example.kitt.model.VehicleItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface KittAPI {
    String BASE_URL = Endpoint.BASE_URL;


    @GET("marcas_carros/")
    Call<List<BrandItem>> findAllBrandCar();

    @GET("marcas_motos/")
    Call<List<BrandItem>> findAllBrandMoto();

    @GET("revistas/")
    Call<List<NewsItem>> findAllNewsCar();

    @GET("revistas_moto/")
    Call<List<NewsItem>> findAllNewsMoto();


    @GET("{marca}")
    Call<List<VehicleItem>> findAllVehicle(@Path("marca") String marca);

    @GET("{id}")
    Call<List<String>> findDetailsVehicles(@Path("id") String id);


}


