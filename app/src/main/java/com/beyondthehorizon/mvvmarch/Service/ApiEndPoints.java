package com.beyondthehorizon.mvvmarch.Service;


import com.beyondthehorizon.mvvmarch.EmployeeApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("users/?per_page=12&amp;page=1")
    Call<EmployeeApiResponse> getEmployees();
}
