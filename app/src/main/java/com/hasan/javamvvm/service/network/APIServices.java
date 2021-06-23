package com.hasan.javamvvm.service.network;

import com.hasan.javamvvm.service.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {

    @GET("3/movie/top_rated?api_key=34733c2580b8548dcb0b7ef146c38fb6")
    Call<MovieModel> getTopRatedMovieList();
}
