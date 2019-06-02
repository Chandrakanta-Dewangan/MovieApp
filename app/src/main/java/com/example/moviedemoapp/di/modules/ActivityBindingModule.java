package com.example.moviedemoapp.di.modules;

import com.example.moviedemoapp.view.activity.MovieHomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {FragmentBindingModule.class})
    public abstract MovieHomeActivity bindAtMainActivity();
}