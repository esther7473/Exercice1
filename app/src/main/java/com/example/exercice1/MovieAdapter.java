package com.example.exercice1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<Movie> movieList;
    Context context;


    public MovieAdapter(Context context, List<Movie> movieList ) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MovieViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieList.get(position);
        Log.d("ro", String.valueOf(movie.getYear()));
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.runtime.setText(movie.getRuntime());
        Glide.with(this.context).load(movie.getPoster()).into(holder.movieImage);

        holder.itemViewLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , MovieDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title" , movie.getTitle());
                bundle.putString("year" , movie.getYear());
                bundle.putString("poster" , movie.getPoster());
                bundle.putString("runtime" , movie.getRuntime());
                bundle.putParcelableArrayList("movieList", (ArrayList<? extends Parcelable>) movieList);
                intent.putExtras(bundle);

                Log.d("ro_intent", intent.getStringExtra("title"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return movieList.size();
//        return 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{

        TextView title,year, runtime;
        ImageView movieImage;
        LinearLayout itemViewLinear;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movie_image);
            title = itemView.findViewById(R.id.title);
            year = itemView.findViewById(R.id.year);
            runtime = itemView.findViewById(R.id.runtime);
            itemViewLinear = itemView.findViewById(R.id.itemViewLinear);
        }


    }
//    public  void  deleteMovie(Movie movie){
//        this.movieList.remove(movie);
//    }

}
