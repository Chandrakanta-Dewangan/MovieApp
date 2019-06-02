package com.example.moviedemoapp.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.example.moviedemoapp.di.util.ViewModelKey;
import com.example.moviedemoapp.util.ViewModelFactory;
import com.example.moviedemoapp.viewmodel.MovieDetailsViewModel;
import com.example.moviedemoapp.viewmodel.MovieListViewModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    abstract ViewModel bindMovieListViewModel(MovieListViewModel movieListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(MovieDetailsViewModel detailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
