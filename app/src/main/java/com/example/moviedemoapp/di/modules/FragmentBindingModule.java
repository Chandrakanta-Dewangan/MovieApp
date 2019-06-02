package com.example.moviedemoapp.di.modules;

import com.example.moviedemoapp.view.fragments.MovieDetailsFragment;
import com.example.moviedemoapp.view.fragments.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Chandrakanta on 01/06/2019.
 */


@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    public abstract MovieListFragment provideListFragment();

    @ContributesAndroidInjector
    public abstract MovieDetailsFragment provideDetailsFragment();


}
