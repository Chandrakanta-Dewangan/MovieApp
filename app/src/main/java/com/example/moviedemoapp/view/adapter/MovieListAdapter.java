package com.example.moviedemoapp.view.adapter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviedemoapp.R;
import com.example.moviedemoapp.data.model.Movie;
import com.example.moviedemoapp.data.model.MovieDetailModel;
import com.example.moviedemoapp.data.model.MovieListData;
import com.example.moviedemoapp.view.base.BaseActivity;
import com.example.moviedemoapp.view.base.BaseApplication;
import com.example.moviedemoapp.viewmodel.MovieListViewModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Chandrakanta on 01/06/2019.
 */

public class MovieListAdapter extends BaseAdapter {
    private final List<Movie> data = new ArrayList<>();
    private Context mContext;
    private MovieListViewModel movieListViewModel;
    private MovieListData movieList;

    public MovieListAdapter(Context context, MovieListViewModel viewModel, LifecycleOwner lifecycleOwner) {
        this.mContext = context;
        this.movieListViewModel = viewModel;
        viewModel.getMovieData().observe(lifecycleOwner, new Observer<MovieListData>() {
            @Override
            public void onChanged(@Nullable MovieListData movieListData) {
                data.clear();
                if (movieListData != null) {
                    movieList = movieListData;
                    data.addAll(movieListData.getMovieList());
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Movie getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final MovieViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_movie_list_item, null);
            viewHolder = new MovieViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MovieViewHolder) convertView.getTag();
        }
        viewHolder.favouriteImageBtn.setTag(i);
        viewHolder.voterImageBtn.setTag(i);
        final Movie item = getItem(i);
        viewHolder.getPosition = i;
        if(item !=null){
            viewHolder.languageTextView.setText(item.getLangauge());
            viewHolder.movieNameTextView.setText(item.getMovieName());
            viewHolder.voterImageBtn.setText(item.getVoterCount());
        if (item.isFavourite()) {
            viewHolder.favouriteImageBtn.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.colorAccent));
        } else {
            viewHolder.favouriteImageBtn.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.white));
        }
        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(item.getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.posterImageView);

        viewHolder.favouriteImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item != null) {
                    if (item.isFavourite()) {
                        //after click make unfavourite
                        item.setFavourite(false);
                        viewHolder.favouriteImageBtn.setBackgroundTintList(mContext.getColorStateList(R.color.colorAccent));
                    } else {
                        item.setFavourite(true);
                        viewHolder.favouriteImageBtn.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.white));
                    }
                    movieListViewModel.setMovieData(movieList);
                }
            }
        });

    }
        return convertView;
    }

    public static class MovieViewHolder {
        public MovieViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public int getPosition;

        public Movie movie;
        @BindView(R.id.movieNameTv)
        public TextView movieNameTextView;
        @BindView(R.id.languageTv)
        public TextView languageTextView;
        @BindView(R.id.posterIv)
        public ImageView posterImageView;
        @BindView(R.id.favouriteIv)
        public ImageView favouriteImageBtn;
        @BindView(R.id.voterTv)
        public TextView voterImageBtn;


        @OnClick(R.id.voterTv)
        public void onClickVoter() {
            Log.d("ViewHolder", "position ->" + getPosition);
        }


    }

}

