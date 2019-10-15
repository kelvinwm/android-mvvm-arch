package com.beyondthehorizon.fullappprac.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.beyondthehorizon.fullappprac.Repository;
import com.beyondthehorizon.fullappprac.model.MovieModle;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    Repository repository;
    public MoviesViewModel(@NonNull Application application) {
        super(application);
        repository =  new Repository(application);
    }
    public LiveData<List<MovieModle>> getPopularMovies(){

        return  repository.getAllMovie();
    }
}
