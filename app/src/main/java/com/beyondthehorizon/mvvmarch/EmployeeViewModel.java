package com.beyondthehorizon.mvvmarch;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EmployeeViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository(application);
    }

    public LiveData<List<Employee>> getAllEmployees() {
        employeeRepository.getMutableLiveData();
        return employeeRepository.getAllEvents();
    }
}
