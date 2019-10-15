package com.beyondthehorizon.fullappprac;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.beyondthehorizon.fullappprac.Database.MovieDao;
import com.beyondthehorizon.fullappprac.Database.MovieDataBase;
import com.beyondthehorizon.fullappprac.Service.ApiBase;
import com.beyondthehorizon.fullappprac.Service.ApiEndPoints;
import com.beyondthehorizon.fullappprac.model.MovieDbResponse;
import com.beyondthehorizon.fullappprac.model.MovieModle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private LiveData<List<MovieModle>> allMovies;
    private MovieDataBase movieDataBase;
    private MovieDao movieDao;

    public Repository(Application application) {
        movieDataBase = MovieDataBase.getInstance(application);
        movieDao = movieDataBase.movieDao();
        allMovies = movieDao.getAllLocalMovies();
        getAllMovies();
    }

    private void getAllMovies() {
        ApiEndPoints apiEndPoints = ApiBase.getService();
        Call<MovieDbResponse> call = apiEndPoints.allMovies();

        call.enqueue(new Callback<MovieDbResponse>() {
            @Override
            public void onResponse(Call<MovieDbResponse> call, Response<MovieDbResponse> response) {
                MovieDbResponse movieDbResponse = response.body();
//                allMovies.setValue(movieDbResponse.getResults());
                for (MovieModle movie : movieDbResponse.getResults()) {
//                    movieDao.insertMovie(movie);
                    saveToLocalDb(movie);

                }
            }

            @Override
            public void onFailure(Call<MovieDbResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<List<MovieModle>> getAllMovie() {
        return allMovies;
    }

    private void saveToLocalDb(MovieModle movie) {
        new InsertAysncTask(movieDao).execute(movie);
    }

    private static class InsertAysncTask extends AsyncTask<MovieModle, Void, Void> {
        private MovieDao movieDao;

        public InsertAysncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(MovieModle... movieModles) {
            movieDao.insertMovie(movieModles[0]);
            return null;
        }
    }

    private static class UpdateAysncTask extends AsyncTask<MovieModle, Void, Void> {
        private MovieDao movieDao;

        public UpdateAysncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(MovieModle... movieModles) {
            movieDao.deleteAllCurrentMovies();
            return null;
        }

    }
}