package com.example.moviedemoapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieListData {
    @SerializedName("Messages")
    List<Messages> messages;
    @SerializedName("Movie")
    List<Movie> movieList;

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
