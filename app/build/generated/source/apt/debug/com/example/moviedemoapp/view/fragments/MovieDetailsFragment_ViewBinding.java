// Generated code from Butter Knife. Do not modify!
package com.example.moviedemoapp.view.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.moviedemoapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieDetailsFragment_ViewBinding implements Unbinder {
  private MovieDetailsFragment target;

  private View view2131165242;

  private View view2131165338;

  @UiThread
  public MovieDetailsFragment_ViewBinding(final MovieDetailsFragment target, View source) {
    this.target = target;

    View view;
    target.movieNameTextView = Utils.findRequiredViewAsType(source, R.id.movieNameTv, "field 'movieNameTextView'", TextView.class);
    target.posterImageView = Utils.findRequiredViewAsType(source, R.id.posterIv, "field 'posterImageView'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.favouriteIv, "field 'favouriteImageBtn' and method 'onClickFavourite'");
    target.favouriteImageBtn = Utils.castView(view, R.id.favouriteIv, "field 'favouriteImageBtn'", ImageView.class);
    view2131165242 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickFavourite();
      }
    });
    view = Utils.findRequiredView(source, R.id.voterTv, "field 'voterImageBtn' and method 'onClickVoter'");
    target.voterImageBtn = Utils.castView(view, R.id.voterTv, "field 'voterImageBtn'", TextView.class);
    view2131165338 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickVoter();
      }
    });
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'titleTv'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieDetailsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.movieNameTextView = null;
    target.posterImageView = null;
    target.favouriteImageBtn = null;
    target.voterImageBtn = null;
    target.titleTv = null;

    view2131165242.setOnClickListener(null);
    view2131165242 = null;
    view2131165338.setOnClickListener(null);
    view2131165338 = null;
  }
}
