package com.example.exercice1;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exercice1.databinding.ActivityMovieDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie_detail);


        ImageView movieImage = findViewById(R.id.detail_movie_image);
        TextView title = findViewById(R.id.detail_title);
        TextView year = findViewById(R.id.detail_year);
        TextView runtime = findViewById(R.id.detail_runtime);


        Intent intent = this.getIntent();
//        Bundle bundle = intent.getExtras();
        String Dtitle = intent.getStringExtra("title");
        String Dposter = intent.getStringExtra("poster");
        String Dyear = intent.getStringExtra("year");
        String Druntime = intent.getStringExtra("runtime");



        Glide.with(this).load(Dposter).into(movieImage);
        title.setText(Dtitle);
        year.setText(Dyear);
        runtime.setText(Druntime);

//        bouton retour
        Button retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        bouton supprimer
        Button supprimer = findViewById(R.id.supprimer);
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ro", "bouton supprimer clique! ");
                finish();

//                ArrayList<Movie> movieList = bundle.getParcelableArrayList("movieList");
//                List<Movie> movieList = MainActivity.getMovieList();
//
////                MovieAdapter movieAdapter = MainActivity.getMovieAdapter();
//
//
//                Movie movieToDelete = null;
//                for (Movie movie : movieList) {
//                    if (movie.getTitle().equals(Dtitle) &&
//                            movie.getYear().equals(Dyear) &&
//                            movie.getPoster().equals(Dposter) &&
//                            movie.getRuntime().equals(Druntime)) {
//                        movieToDelete = movie;
//                        break;
//                    }
//                }
//                if (movieToDelete != null) {
////                    movieAdapter.deleteMovie(movieToDelete);
////                    movieAdapter.notifyDataSetChanged();
////                    finish();
////                    Intent resultIntent = new Intent();
////                    resultIntent.putExtra("updatedList", new ArrayList<>(movieList));
////                    setResult(RESULT_OK, resultIntent);
////                    finish();
//
//                }
            }
        });

    }



}