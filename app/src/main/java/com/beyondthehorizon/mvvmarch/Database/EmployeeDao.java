package com.beyondthehorizon.mvvmarch.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.beyondthehorizon.mvvmarch.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee_table_two")
    LiveData<List<Employee>> allEmployees();

    @Insert
    void insertEmployee(Employee... employee);

    @Query("DELETE FROM employee_table_two")
    void deleteAllEmployee();
}
