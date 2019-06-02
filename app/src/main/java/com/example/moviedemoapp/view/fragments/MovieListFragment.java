package com.example.moviedemoapp.view.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.moviedemoapp.R;
import com.example.moviedemoapp.view.adapter.MovieListAdapter;
import com.example.moviedemoapp.view.base.BaseFragment;
import com.example.moviedemoapp.data.model.MovieListData;
import com.example.moviedemoapp.util.ViewModelFactory;
import com.example.moviedemoapp.viewmodel.MovieDetailsViewModel;
import com.example.moviedemoapp.viewmodel.MovieListViewModel;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieListFragment extends BaseFragment {

    @BindView(R.id.movieGridview)
    public GridView listView;
    @BindView(R.id.tv_error)
    public TextView errorTextView;
    @BindView(R.id.loading_view)
    public View loadingView;
    @BindView(R.id.toolbar)
    public Toolbar titleTv;

    @Inject
    ViewModelFactory viewModelFactory;
    private MovieListViewModel viewModel;

    private MovieListData movieListDatas;
    private MovieListAdapter adapter;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_movie_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel.class);

    }

    @Override
    public void onResume() {
        super.onResume();
        //getActivity().setTitle(getString(R.string.movie_list));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        titleTv.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        adapter = new MovieListAdapter(getBaseActivity(), viewModel, this);
        listView.setAdapter(adapter);
        makeMovieListCall();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getBaseActivity(), "You clicked: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                MovieDetailsViewModel detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(MovieDetailsViewModel.class);
                detailsViewModel.setSelectedMovieDetails(adapter.getItem(position));
                replaceFragment(new MovieDetailsFragment(), R.id.container);
            }
        });


    }



    /*
     * Method to call the ViewModel of Auth Token API which will hit the API & will give the response.
     * */
    protected void makeMovieListCall() {
        if (isNetworkConnected()) {
            if (movieListDatas == null) {
                makeMovieDetailsCall();
            } else {
                loadingView.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(getContext(), getString(R.string.internet_error_msg), Toast.LENGTH_SHORT).show();
        }
    }


    /*
     * Method to call the ViewModel of Movie Details API which will hit the API & will give the response.
     * */
    protected void makeMovieDetailsCall() {
        viewModel.getProgressDialog().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                    if (isLoading) {
                        errorTextView.setVisibility(View.GONE);
                        listView.setVisibility(View.GONE);
                    }
                }
            }
        });


        viewModel.getMovieData().observe(this, new Observer<MovieListData>() {
            @Override
            public void onChanged(@Nullable MovieListData movieListData) {
                movieListDatas = movieListData;
                errorTextView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });

        viewModel.getErrorMsg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
        });
        viewModel.makeMovieListCall();
    }
}
