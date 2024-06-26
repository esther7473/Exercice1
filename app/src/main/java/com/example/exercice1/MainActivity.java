package com.example.exercice1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
//    public static List<Movie> movieList;
//    public MovieAdapter movieAdapter = new MovieAdapter(this,movieList);


    @SuppressLint("MissingInflatedId")
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.d("ro", "onCreate: la vue main cree");
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(null);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/horizon-code-academy/fake-movies-api/")
//                .baseUrl("https://json-generator.com/api/json/get/")

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

//            Appel de l'API
            MovieJson movieJson = retrofit.create(MovieJson.class);
            Call<List<Movie>> call = movieJson.getMovie();
            call.enqueue(new Callback<List<Movie>>() {
                @Override
                public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                        Log.d("Ro", String.valueOf(response.code()));
                        return;
                    }
                    List<Movie>  movieList = response.body();
                    movieList.addAll(movieList);
                    MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this,movieList);
                    recyclerView.setAdapter(movieAdapter);

                }

                @Override
                public void onFailure(Call<List<Movie>> call, Throwable t) {
                    Log.d("Ro", t.getMessage());
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });



    }

    public void removeMovieFromList(String item){


    }
//    public static List<Movie> getMovieList() {
//        return movieList;
//    }
//    public   MovieAdapter getMovieAdapter(){
//
//        return movieAdapter;
//    }
}