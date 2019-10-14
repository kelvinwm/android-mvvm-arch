package com.beyondthehorizon.mvvmarch;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.beyondthehorizon.mvvmarch.Database.EmployeeDao;
import com.beyondthehorizon.mvvmarch.Database.EmployeeDatabase;
import com.beyondthehorizon.mvvmarch.Service.ApiEndPoints;
import com.beyondthehorizon.mvvmarch.Service.ApiServiceBase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<List<Employee>> mutableLiveData = new MutableLiveData<>();
    LiveData<List<Employee>> allEmployees;
    private EmployeeDao employeeDao;

    public EmployeeRepository(Application application) {
        EmployeeDatabase employeeDatabase = EmployeeDatabase.getInstance(application);
        employeeDao = employeeDatabase.employeeDao();
        allEmployees = employeeDao.allEmployees();
    }

    public MutableLiveData<List<Employee>> getMutableLiveData() {
        final ApiEndPoints apiEndPoints = ApiServiceBase.getService();
        Call<EmployeeApiResponse> call = apiEndPoints.getEmployees();

        call.enqueue(new Callback<EmployeeApiResponse>() {
            @Override
            public void onResponse(Call<EmployeeApiResponse> call, Response<EmployeeApiResponse> response) {
                EmployeeApiResponse employeeApiResponse = response.body();
                if (employeeApiResponse != null && employeeApiResponse.getEmployeesList() != null) {
                    employees = (ArrayList<Employee>) employeeApiResponse.getEmployeesList();

//                    allEmployees = (ArrayList<Employee>) employeeApiResponse.getEmployeesList();
                    mutableLiveData.setValue(employees);
                    for (Employee employee : employees) {
                        Log.d("MIMI", "onResponse: 123");
                        insert(employee);
                    }
                }
            }

            @Override
            public void onFailure(Call<EmployeeApiResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public void insert(Employee event) {
        new InsertAsyncTask(employeeDao).execute(event);
    }

    public LiveData<List<Employee>> getAllEvents() {
        return allEmployees;
    }


    private static class InsertAsyncTask extends AsyncTask<Employee, Void, Void> {
        private EmployeeDao eventsDao;

        private InsertAsyncTask(EmployeeDao eventsDao) {
            this.eventsDao = eventsDao;
        }

        @Override
        protected Void doInBackground(Employee... events) {
            eventsDao.insertEmployee(events);
            return null;
        }
    }

}