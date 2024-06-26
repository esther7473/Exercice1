package com.example.exercice1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Movie implements Parcelable {


    private String Title;
    private String Year;
    private String Runtime;
    private String Poster;

    protected Movie(Parcel in) {
        Title = in.readString();
        Year = in.readString();
        Runtime = in.readString();
        Poster = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Poster='" + Poster + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getPoster() {
        return Poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Year);
        dest.writeString(Runtime);
        dest.writeString(Poster);
    }
}
