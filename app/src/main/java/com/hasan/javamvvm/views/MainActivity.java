package com.hasan.javamvvm.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.hasan.javamvvm.adapters.MovieAdapter;
import com.hasan.javamvvm.databinding.ActivityMainBinding;
import com.hasan.javamvvm.service.model.Result;
import com.hasan.javamvvm.viewModels.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MovieListViewModel movieListViewModel;
    private MovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerview.setLayoutManager(new GridLayoutManager(this, 2));

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        movieListViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                adapter = new MovieAdapter(MainActivity.this, results);
                binding.recyclerview.setAdapter(adapter);
            }
        });


    }
}