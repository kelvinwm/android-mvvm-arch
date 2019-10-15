package com.beyondthehorizon.fullappprac.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {
    private static Retrofit retrofit;
    private static final String Base_Url = "https://api.themoviedb.org/3/movie/";

    public static ApiEndPoints getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiEndPoints.class);
    }

}
