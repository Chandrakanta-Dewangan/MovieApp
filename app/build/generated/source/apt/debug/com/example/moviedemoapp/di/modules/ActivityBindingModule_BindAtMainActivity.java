package com.example.moviedemoapp.di.modules;

import android.app.Activity;
import com.example.moviedemoapp.view.activity.MovieHomeActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBindingModule_BindAtMainActivity.MovieHomeActivitySubcomponent.class
)
public abstract class ActivityBindingModule_BindAtMainActivity {
  private ActivityBindingModule_BindAtMainActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(MovieHomeActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      MovieHomeActivitySubcomponent.Builder builder);

  @Subcomponent(modules = FragmentBindingModule.class)
  public interface MovieHomeActivitySubcomponent extends AndroidInjector<MovieHomeActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieHomeActivity> {}
  }
}
