package com.hasan.javamvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hasan.javamvvm.databinding.MovieRowBinding;
import com.hasan.javamvvm.service.model.Result;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.ResourceBundle;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Result> results;

    public MovieAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieRowBinding movieRowBinding = MovieRowBinding.inflate(layoutInflater,parent,false);
        return new MovieViewHolder(movieRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        Result result = results.get(position);
        String imgUrl = "https://image.tmdb.org/t/p/w500/" + result.getPosterPath();

        Glide.with(context).load(imgUrl).into(holder.movieRowBinding.avatar);
        holder.movieRowBinding.titleTV.setText(result.getTitle());
        holder.movieRowBinding.ratingTV.setText(result.getVoteAverage().toString());
        holder.movieRowBinding.releaseDateTV.setText(result.getReleaseDate());

        // https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieRowBinding movieRowBinding;
        public MovieViewHolder(MovieRowBinding movieRowBinding) {
            super(movieRowBinding.getRoot());
            this.movieRowBinding = movieRowBinding;
        }
    }
}
