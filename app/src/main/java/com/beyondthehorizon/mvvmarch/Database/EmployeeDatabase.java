package com.beyondthehorizon.mvvmarch.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.beyondthehorizon.mvvmarch.Employee;

@Database(entities = Employee.class, exportSchema = false, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {
    private static final String DB_NAME = "event_db_po";
    private static EmployeeDatabase instance;

    public static synchronized EmployeeDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), EmployeeDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract EmployeeDao employeeDao();

}
