package com.example.moviedemoapp.data.model;

import android.view.View;
/**
 * Created by Chandrakanta on 01/06/2019.
 */
public class MovieDetailModel {
    private Movie data;
    private final String emptyString = "";

    public MovieDetailModel(Movie data) {
        this.data = data;
    }

    private boolean isDataAvailable() {
        return data != null ? true : false;
    }

    public String getMovieName() {
        if (isDataAvailable()) {
            return new StringBuffer().append(data.getLangauge()).append(": ").append(data.getMovieName()).toString();
        } else {
            return emptyString;
        }
    }

    public String getVoterCount() {
        if (isDataAvailable()) {
            return data.getVoterCount().toString();
        } else {
            return emptyString;
        }
    }

    public boolean isFavourite() {
        if (isDataAvailable()) {
            return data.isFavourite();
        } else {
            return false;
        }
    }

    public String getPosterURL() {
        if (isDataAvailable()) {
            return data.getThumbnailUrl().toString();
        } else {
            return emptyString;
        }
    }

}
