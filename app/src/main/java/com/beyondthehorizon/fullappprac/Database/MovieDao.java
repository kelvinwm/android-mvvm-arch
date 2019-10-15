package com.beyondthehorizon.fullappprac.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.beyondthehorizon.fullappprac.model.MovieModle;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie_table")
    LiveData<List<MovieModle>> getAllLocalMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(MovieModle movieModle);

    @Update
    void updateMovie(MovieModle movieModle);

    @Query("DELETE FROM movie_table")
    void deleteAllCurrentMovies();
}
