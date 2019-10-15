package com.beyondthehorizon.fullappprac.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.beyondthehorizon.fullappprac.model.MovieModle;

@Database(entities = {MovieModle.class}, exportSchema = false, version = 1)
public abstract class MovieDataBase extends RoomDatabase {
    private static final String DB_NAME = "movie_db";
    private static MovieDataBase instance;

    public abstract MovieDao movieDao();

    public static synchronized MovieDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MovieDataBase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
