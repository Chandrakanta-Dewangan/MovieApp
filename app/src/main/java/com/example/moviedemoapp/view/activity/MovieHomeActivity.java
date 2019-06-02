package com.example.moviedemoapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.moviedemoapp.R;
import com.example.moviedemoapp.view.base.BaseActivity;
import com.example.moviedemoapp.view.fragments.MovieListFragment;

import butterknife.BindView;

/**
 * Created by Chandrakanta on 01/06/2019.
 */
public class MovieHomeActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_movie_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            addFragment(new MovieListFragment(), R.id.container);
        }
    }


}
