package com.example.moviedemoapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;


import com.example.moviedemoapp.data.model.Movie;

import javax.inject.Inject;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieDetailsViewModel extends BaseViewModel {
    private final MutableLiveData<Movie> movieDetails = new MutableLiveData<>();

    public LiveData<Movie> getSelectedMovieDetails() {
        return movieDetails;
    }

    @Inject
    public MovieDetailsViewModel() {
    }

    /*
    * Method to set required Movie Details.
    * */
    public void setSelectedMovieDetails(Movie movie) {
        if (movie != null) {
            movieDetails.setValue(movie);
        }
    }
}
