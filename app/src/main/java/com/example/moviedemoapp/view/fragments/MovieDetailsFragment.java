package com.example.moviedemoapp.view.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviedemoapp.R;
import com.example.moviedemoapp.data.model.Movie;
import com.example.moviedemoapp.data.model.MovieDetailModel;
import com.example.moviedemoapp.util.ViewModelFactory;
import com.example.moviedemoapp.view.base.BaseFragment;
import com.example.moviedemoapp.viewmodel.MovieDetailsViewModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieDetailsFragment extends BaseFragment {
    @BindView(R.id.movieNameTv)
    public TextView movieNameTextView;
    @BindView(R.id.posterIv)
    public ImageView posterImageView;
    @BindView(R.id.favouriteIv)
    public ImageView favouriteImageBtn;
    @BindView(R.id.voterTv)
    public TextView voterImageBtn;
    @BindView(R.id.toolbar)
    public Toolbar titleTv;

    private Movie movieData;

    @Inject
    ViewModelFactory viewModelFactory;
    private MovieDetailsViewModel detailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_movie_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        titleTv.setNavigationIcon(R.drawable.back_icon);
        titleTv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(MovieDetailsViewModel.class);
        displayMovieDetails();
    }

    @OnClick(R.id.voterTv)
    public void onClickVoter() {
        if (movieData != null) {
            if(movieData.getVoterCount() != null){
                int count =Integer.parseInt(movieData.getVoterCount())+1;
                movieData.setVoterCount(""+count);
                voterImageBtn.setText(""+count);
                detailsViewModel.setSelectedMovieDetails(movieData);
            }
        }
    }

    @OnClick(R.id.favouriteIv)
    public void onClickFavourite() {
        if (movieData != null) {
            if (movieData.isFavourite()) {
                //after click make unfavourite
                movieData.setFavourite(false);
                favouriteImageBtn.setBackgroundTintList(getBaseActivity().getResources().getColorStateList(R.color.colorAccent));
            } else {
                movieData.setFavourite(true);
                favouriteImageBtn.setBackgroundTintList(getBaseActivity().getResources().getColorStateList(R.color.white));
            }
            detailsViewModel.setSelectedMovieDetails(movieData);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void displayMovieDetails() {
        detailsViewModel.getSelectedMovieDetails().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(@Nullable Movie movie) {
                if (movie != null) {
                    movieData = movie;
                    MovieDetailModel detailModel = new MovieDetailModel(movie);
                    movieNameTextView.setText(detailModel.getMovieName());
                    if (detailModel.isFavourite()) {
                        favouriteImageBtn.setBackgroundTintList(getBaseActivity().getResources().getColorStateList(R.color.colorAccent));
                    } else {
                        favouriteImageBtn.setBackgroundTintList(getBaseActivity().getResources().getColorStateList(R.color.white));
                    }
                    voterImageBtn.setText(detailModel.getVoterCount());
                    Picasso.Builder builder = new Picasso.Builder(getActivity());
                    builder.downloader(new OkHttp3Downloader(getActivity()));
                    builder.build().load(detailModel.getPosterURL())
                            .placeholder((R.drawable.ic_launcher_background))
                            .error(R.drawable.ic_launcher_background)
                            .into(posterImageView);

                }
            }
        });

    }
}
