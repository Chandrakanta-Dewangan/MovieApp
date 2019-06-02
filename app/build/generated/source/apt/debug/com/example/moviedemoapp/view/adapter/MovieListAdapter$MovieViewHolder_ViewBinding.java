// Generated code from Butter Knife. Do not modify!
package com.example.moviedemoapp.view.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.moviedemoapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieListAdapter$MovieViewHolder_ViewBinding implements Unbinder {
  private MovieListAdapter.MovieViewHolder target;

  private View view2131165338;

  @UiThread
  public MovieListAdapter$MovieViewHolder_ViewBinding(final MovieListAdapter.MovieViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.movieNameTextView = Utils.findRequiredViewAsType(source, R.id.movieNameTv, "field 'movieNameTextView'", TextView.class);
    target.languageTextView = Utils.findRequiredViewAsType(source, R.id.languageTv, "field 'languageTextView'", TextView.class);
    target.posterImageView = Utils.findRequiredViewAsType(source, R.id.posterIv, "field 'posterImageView'", ImageView.class);
    target.favouriteImageBtn = Utils.findRequiredViewAsType(source, R.id.favouriteIv, "field 'favouriteImageBtn'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.voterTv, "field 'voterImageBtn' and method 'onClickVoter'");
    target.voterImageBtn = Utils.castView(view, R.id.voterTv, "field 'voterImageBtn'", TextView.class);
    view2131165338 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickVoter();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieListAdapter.MovieViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.movieNameTextView = null;
    target.languageTextView = null;
    target.posterImageView = null;
    target.favouriteImageBtn = null;
    target.voterImageBtn = null;

    view2131165338.setOnClickListener(null);
    view2131165338 = null;
  }
}
