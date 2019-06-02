package com.example.moviedemoapp.di.component;

import android.app.Application;


import com.example.moviedemoapp.view.base.BaseApplication;
import com.example.moviedemoapp.di.modules.ActivityBindingModule;
import com.example.moviedemoapp.di.modules.ApplicationModule;
import com.example.moviedemoapp.di.modules.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    public void inject(BaseApplication application);

    @Component.Builder
    public interface Builder {
        @BindsInstance
        public Builder application(Application application);

        public ApplicationComponent build();
    }
}
