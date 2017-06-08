package com.example.home.vrticcoa.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.home.vrticcoa.BasePresenter;
import com.example.home.vrticcoa.MvpView;
import com.example.home.vrticcoa.R;
import com.example.home.vrticcoa.Second3Activity;
import com.example.home.vrticcoa.raport.RaportMvp;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by home on 6/7/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context mContext;
    private List<Card> cards;
    private onImageClick onImageClick;

    public void setCards(List<Card> cards) {
        this.cards = cards;
        notifyDataSetChanged();
    }


    public interface onImageClick{
        void OnImageClick();
    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_card, parent, false);
        return new  MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Card card=cards.get(position);
        holder.title.setText(card.getName());

        Glide.with(mContext).load(card.getThumbnail()).into(holder.thumbnail);

    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(final View itemView) {
            super(itemView);


            title = (TextView) itemView.findViewById(R.id.title);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            ButterKnife.bind(this,itemView);

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImageClick.OnImageClick();
                }
            });


        }


    }

    public CardAdapter(Context mContext,onImageClick onImageClick) {
        this.mContext = mContext;
        this.onImageClick=onImageClick;

    }
}
