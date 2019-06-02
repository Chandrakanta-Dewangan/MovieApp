package com.example.moviedemoapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class Movie {
    @SerializedName("MovieName")
    private String movieName;
    @SerializedName("Langauge")
    private String langauge;
    @SerializedName("isFavourite")
    private boolean isFavourite;
    @SerializedName("VoterCount")
    private String voterCount;
    @SerializedName("ThumbURL")
    private String thumbnailUrl;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLangauge() {
        return langauge;
    }

    public void setLangauge(String langauge) {
        this.langauge = langauge;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getVoterCount() {
        return voterCount;
    }

    public void setVoterCount(String voterCount) {
        this.voterCount = voterCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
