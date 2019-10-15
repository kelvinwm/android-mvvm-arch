package com.beyondthehorizon.fullappprac.Service;

import com.beyondthehorizon.fullappprac.model.MovieDbResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("popular?api_key=fa1c4607a8761d4ba535bf138fab7534&language=en-US&page=1")
    Call<MovieDbResponse> allMovies();

}
