package com.example.moviedemoapp.data.rest;

/**
 * Response listener for API requests.
 * Created by Chandrakanta on 01/06/2019.
 */

public interface ResponseListener<T> {
    void onSuccess(T t);

    void onError(String msg);
}
