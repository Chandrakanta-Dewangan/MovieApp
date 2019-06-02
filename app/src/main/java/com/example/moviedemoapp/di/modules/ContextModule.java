package com.example.moviedemoapp.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

@Module
public abstract class ContextModule {

    @Binds
    abstract Context provideContext(Application application);
}