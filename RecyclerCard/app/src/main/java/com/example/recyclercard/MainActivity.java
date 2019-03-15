package com.example.recyclercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<exampleitem> exampleitemArrayList;
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this);


        exampleitemArrayList = new ArrayList<exampleitem>();

        generateFakeData();

        adapter = new ExampleAdapter(exampleitemArrayList);







        configRecyclerView();




    }


    public  void  generateFakeData(){

        exampleitemArrayList.add(new exampleitem(R.drawable.p1,"PICTURE 1"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p2,"PICTURE 2"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p3,"PICTURE 3"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p4,"PICTURE 4"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p5,"PICTURE 5"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p6,"PICTURE 6"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p7,"PICTURE 7"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p8,"PICTURE 8"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p9,"PICTURE 9"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p10,"PICTURE 10"));
        exampleitemArrayList.add(new exampleitem(R.drawable.p11,"PICTURE 11"));




    }

    public void configRecyclerView(){



        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);


    }
}
