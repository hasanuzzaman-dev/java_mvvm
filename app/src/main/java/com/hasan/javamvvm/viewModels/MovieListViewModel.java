package com.hasan.javamvvm.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hasan.javamvvm.service.model.Result;
import com.hasan.javamvvm.service.repositories.MovieRepository;
import com.hasan.javamvvm.service.repositories.MovieRepositoryImpl;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {
    private final MovieRepositoryImpl movieRepositoryImpl;

    public MovieListViewModel(Application application) {
        super(application);
         movieRepositoryImpl = MovieRepository.getMovieRepository(application);
    }

    public LiveData<List<Result>> getTopRatedMovieList() {
        return movieRepositoryImpl.getTopRatedMovieList();
    }
}
