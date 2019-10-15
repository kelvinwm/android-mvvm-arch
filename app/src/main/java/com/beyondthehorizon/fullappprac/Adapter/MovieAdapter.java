package com.beyondthehorizon.fullappprac.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.beyondthehorizon.fullappprac.R;
import com.beyondthehorizon.fullappprac.databinding.MovieItemBinding;
import com.beyondthehorizon.fullappprac.model.MovieModle;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    ArrayList<MovieModle> movieModles = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding movieItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_item, parent, false);
        return new MovieViewHolder(movieItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final MovieModle movieModle = movieModles.get(position);
        holder.movieItemBinding.setMovie(movieModle);
    }

    @Override
    public int getItemCount() {
        return movieModles.size();
    }

    public void setMovieList(ArrayList<MovieModle> movieList) {
        this.movieModles = movieList;
        notifyDataSetChanged();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding movieItemBinding;
        View view;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieItemBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MovieModle movieModle = movieItemBinding.getMovie();
                    Log.d("MIMI", "onClick: " + movieModle.getTitle());
                }
            });
        }
    }
}
