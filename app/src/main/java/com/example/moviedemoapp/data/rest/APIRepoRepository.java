package com.example.moviedemoapp.data.rest;

import com.example.moviedemoapp.data.model.MovieListData;
import com.google.gson.JsonObject;


import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class APIRepoRepository {

    private final APIRepo repoService;

    @Inject
    public APIRepoRepository(APIRepo repoService) {
        this.repoService = repoService;
    }

    public Single<MovieListData> getMovieList() {
        return repoService.getMovieList();
    }
}
