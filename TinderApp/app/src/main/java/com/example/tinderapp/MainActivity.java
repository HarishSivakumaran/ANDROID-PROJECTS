package com.example.tinderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<TinderCardData> TinderFakeDataList;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);

        generateFakeData();

        adapter = new TinderAdapter(TinderFakeDataList);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);



    }

    public void generateFakeData(){

        TinderFakeDataList = new ArrayList<TinderCardData>();

        TinderFakeDataList.add(new TinderCardData(R.drawable.f1,"food 1"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f2,"food 2"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f3,"food 3"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f4,"food 4"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f5,"food 5"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f6,"food 6"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f7,"food 7"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f8,"food 8"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f9,"food 9"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f10,"food 10"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f11,"food 11"));
        TinderFakeDataList.add(new TinderCardData(R.drawable.f12,"food 12"));



    }
}
