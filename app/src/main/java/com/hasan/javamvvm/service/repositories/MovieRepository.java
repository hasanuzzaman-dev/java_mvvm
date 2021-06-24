package com.hasan.javamvvm.service.repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.hasan.javamvvm.service.model.MovieModel;
import com.hasan.javamvvm.service.model.Result;
import com.hasan.javamvvm.service.network.APIServices;
import com.hasan.javamvvm.service.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static Context mContext;
    private static MovieRepository movieRepository;
    private MovieModel movieModel;
    private List<Result> results;
    private MutableLiveData mutableLiveData;
    private static final String TAG = "MovieRepository";

    public static MovieRepository getMovieRepository(Context context){
        if (movieRepository == null){
            mContext = context;
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList(){
        Log.d(TAG, "getTopRatedMovieList: started");

        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }

        APIServices apiServices = RetrofitInstance.getRetrofitInstance().create(APIServices.class);
        Call<MovieModel> movieModelCall = apiServices.getTopRatedMovieList();
        movieModelCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Log.d(TAG, "onResponse: statusCode "+response.code());
                movieModel = response.body();
                Toast.makeText(mContext, "status code: "+response.code(), Toast.LENGTH_SHORT).show();
               // Log.d(TAG, "onResponse: "+movieModel.toString());
                results = movieModel.getResults();
                mutableLiveData.postValue(results);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());

            }
        });

        return mutableLiveData;
    };
}
