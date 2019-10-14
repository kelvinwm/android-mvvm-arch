package com.beyondthehorizon.mvvm.Service;

import com.beyondthehorizon.mvvm.EmployeeApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("users/?per_page=12&amp;page=1")
    Call<EmployeeApiResponse> getEmployees();
}
