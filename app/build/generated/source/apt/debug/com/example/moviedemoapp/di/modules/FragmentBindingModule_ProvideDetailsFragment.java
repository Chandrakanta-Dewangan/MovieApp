package com.example.moviedemoapp.di.modules;

import android.support.v4.app.Fragment;
import com.example.moviedemoapp.view.fragments.MovieDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBindingModule_ProvideDetailsFragment.MovieDetailsFragmentSubcomponent.class
)
public abstract class FragmentBindingModule_ProvideDetailsFragment {
  private FragmentBindingModule_ProvideDetailsFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(MovieDetailsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      MovieDetailsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface MovieDetailsFragmentSubcomponent extends AndroidInjector<MovieDetailsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MovieDetailsFragment> {}
  }
}
