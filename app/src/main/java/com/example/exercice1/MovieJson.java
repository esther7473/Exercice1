package com.example.exercice1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieJson {

    @GET("movies")
    Call<List<Movie>> getMovie();
}
