package com.beyondthehorizon.mvvm;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.beyondthehorizon.mvvm.Service.ApiEndPoints;
import com.beyondthehorizon.mvvm.Service.ApiServiceBase;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRepository {
    private ArrayList<Employee> employees = new ArrayList<>();
    private MutableLiveData<List<Employee>> mutableLiveData = new MutableLiveData<>();

    public EmployeeRepository() {
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
                    mutableLiveData.setValue(employees);
                }
            }

            @Override
            public void onFailure(Call<EmployeeApiResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
