package com.example.moviedemoapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.moviedemoapp.data.model.Movie;
import com.example.moviedemoapp.data.model.MovieListData;
import com.example.moviedemoapp.data.rest.APIRepoRepository;
import com.google.gson.JsonObject;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieListViewModel extends BaseViewModel {

    private final MutableLiveData<MovieListData> movieList = new MutableLiveData<>();
    private final APIRepoRepository repoRepository;
    private CompositeDisposable disposable;

    @Inject
    public MovieListViewModel(APIRepoRepository repoRepository) {
        this.repoRepository = repoRepository;
        this.disposable = new CompositeDisposable();
    }

    /*
    * Method to get get all the Patient List by hitting API.
    * */
    public void makeMovieListCall() {
        getProgressDialog().postValue(true);
        disposable.add(repoRepository.getMovieList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<MovieListData>() {
                    @Override
                    public void onSuccess(MovieListData movieListData) {
                        Log.d("Movie data","Movie Data :"+movieListData.getMessages());
                        movieList.postValue(movieListData);
                        getProgressDialog().postValue(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getProgressDialog().postValue(false);
                        getErrorMsg().postValue("");
                    }
                }));
    }

    /*
     * Method to set required Movie Details.
     * */
    public void setMovieData(MovieListData movielist) {
        if (movielist != null) {
            movieList.setValue(movielist);
        }
    }
    public MutableLiveData<MovieListData> getMovieData() {
        return movieList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
