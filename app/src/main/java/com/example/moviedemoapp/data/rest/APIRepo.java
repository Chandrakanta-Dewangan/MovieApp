package com.example.moviedemoapp.data.rest;

import com.example.moviedemoapp.data.model.MovieListData;
import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public interface APIRepo {

    @GET("v2/5cf3dc363300008d187585ce")
    Single<MovieListData> getMovieList();

}
