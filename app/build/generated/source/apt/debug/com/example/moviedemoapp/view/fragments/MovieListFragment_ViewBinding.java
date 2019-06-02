// Generated code from Butter Knife. Do not modify!
package com.example.moviedemoapp.view.fragments;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.moviedemoapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieListFragment_ViewBinding implements Unbinder {
  private MovieListFragment target;

  @UiThread
  public MovieListFragment_ViewBinding(MovieListFragment target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.movieGridview, "field 'listView'", GridView.class);
    target.errorTextView = Utils.findRequiredViewAsType(source, R.id.tv_error, "field 'errorTextView'", TextView.class);
    target.loadingView = Utils.findRequiredView(source, R.id.loading_view, "field 'loadingView'");
    target.titleTv = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'titleTv'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.errorTextView = null;
    target.loadingView = null;
    target.titleTv = null;
  }
}
