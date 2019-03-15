package com.example.tinderapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TinderAdapter extends RecyclerView.Adapter<TinderAdapter.TinderViewHolder> {

    private ArrayList<TinderCardData> mTinderCardDataList;


    public TinderAdapter(ArrayList<TinderCardData> tinderCardDatalist){

        mTinderCardDataList=tinderCardDatalist;
    }

    public static class TinderViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public TinderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.foodimage);
            textView=itemView.findViewById(R.id.text);



        }
    }

    @NonNull
    @Override
    public TinderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tindercards,parent,false);
        TinderViewHolder tinderViewHolder = new TinderViewHolder(view);
        return tinderViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull TinderViewHolder tinderViewHolder, int i) {

        TinderCardData currentData = mTinderCardDataList.get(i);
        tinderViewHolder.imageView.setImageResource(currentData.getmImageId());
        tinderViewHolder.textView.setText(currentData.getmText());



    }

    @Override
    public int getItemCount() {
        return mTinderCardDataList.size();
    }


}
