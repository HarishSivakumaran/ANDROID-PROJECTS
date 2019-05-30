package com.example.recyclercard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> {


    ArrayList<exampleitem> mExampleitemlist;

    public static class  ExampleViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView=itemView.findViewById(R.id.imageViewcard);
            textView=itemView.findViewById(R.id.textcard);
        }
    }

    public ExampleAdapter(ArrayList<exampleitem> exampleitemslist){

        mExampleitemlist=exampleitemslist;
    }



    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {

        exampleitem currentItem = mExampleitemlist.get(i);
        exampleViewHolder.imageView.setImageResource(currentItem.getmImageResource());
        exampleViewHolder.textView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mExampleitemlist.size();
    }






}
