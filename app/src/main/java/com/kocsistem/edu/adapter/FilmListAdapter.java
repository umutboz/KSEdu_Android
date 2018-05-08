package com.kocsistem.edu.adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kocsistem.edu.R;
import com.kocsistem.edu.common.LoadHttpImage;
import com.kocsistem.edu.model.FilmModel;
import com.kocsistem.edu.view.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by UmutBOZ on 29/07/2017.
 */

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.FilmListViewHolder> {
    List<FilmModel> films;
    Context context;
    LayoutInflater layoutInflater;
    public FilmListAdapter(Context mContext, List<FilmModel> mFilms)
    {
        films = mFilms;
        context = mContext;
        layoutInflater  = LayoutInflater.from(context);
    }
    @Override
    public FilmListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.film_list_card_item,parent,false);
        FilmListViewHolder filmListViewHolder = new FilmListViewHolder(view);
        return filmListViewHolder;
    }
    @Override
    public void onBindViewHolder(FilmListViewHolder holder, int position) {
        FilmModel filmModel = films.get(position);
        FilmListViewHolder myViewHolder = holder;
        myViewHolder.initData(filmModel,position);
    }
    @Override
    public int getItemCount() {
        return films.size();
    }
    public class FilmListViewHolder extends RecyclerView.ViewHolder
    {
        FilmModel filmModel;
        TextView titleTv,descTv;
        ImageView posterImgV;
        int currentPosition;
        CardView cardView;
        public FilmListViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView)itemView.findViewById(R.id.film_list_card_item_title_tv);
            descTv = (TextView)itemView.findViewById(R.id.film_list_card_item_desc_tv);
            posterImgV =(ImageView) itemView.findViewById(R.id.film_list_card_item_img);
        }
        public  void initData(FilmModel model, int position)
        {
            this.filmModel = model;
            this.currentPosition = position;
            titleTv.setText(filmModel.getTitle());
            descTv.setText(filmModel.getDescription());
            //new LoadHttpImage(this.posterImgV).execute(filmModel.getPosterUrl());
            Picasso.with(context).load(filmModel.getPosterUrl()).into(posterImgV);
        }
    }
}


/*
  View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, VodDetailActivity.class);
                intent.putExtra("poster", filmModel.getPosterUrl());
                intent.putExtra("title", filmModel.getTitle());
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View,String>(posterImgV,"poster_anime");
                    pairs[1] = new Pair<View,String>(titleTv,"title_anime");

                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(((MainActivity)context),pairs);
                    context.startActivity(intent,activityOptions.toBundle());

                }else
                {
                    context.startActivity(intent);
                }
            }
        };
 */