package com.example.bakingapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<PopularMoviesResponseModel> doGetPopularMovieList();
}