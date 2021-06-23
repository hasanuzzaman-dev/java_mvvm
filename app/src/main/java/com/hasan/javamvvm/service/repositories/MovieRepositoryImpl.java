package com.hasan.javamvvm.service.repositories;

import androidx.lifecycle.MutableLiveData;

import com.hasan.javamvvm.service.model.Result;

import java.util.List;

public interface MovieRepositoryImpl {

    MutableLiveData<List<Result>> getTopRatedMovieList();
}
