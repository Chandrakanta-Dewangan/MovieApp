package com.example.moviedemoapp.di.modules;

import android.support.v4.app.Fragment;
import com.example.moviedemoapp.view.fragments.MovieListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = FragmentBindingModule_ProvideListFragment.MovieListFragmentSubcomponent.class
)
public abstract class FragmentBindingModule_ProvideListFragment {
  private FragmentBindingModule_ProvideListFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(MovieListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MovieListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface MovieListFragmentSubcomponent extends AndroidInjector<MovieListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieListFragment> {}
  }
}
