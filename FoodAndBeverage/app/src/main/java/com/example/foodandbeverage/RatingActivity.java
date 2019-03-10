package com.example.foodandbeverage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {


    RatingBar ratingBar;
    Button submit;
    TextView textView;
    String foodval1;
    String beverageval1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        submit=findViewById(R.id.submit);
        ratingBar=findViewById(R.id.ratingBar);
        textView=findViewById(R.id.textView);

         foodval1 = getIntent().getStringExtra("foodval");
         beverageval1 = getIntent().getStringExtra("beverageval");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("FOOD ORDERED : " + foodval1 + "\n BEVERAGE ORDERED : " + beverageval1);

            }
        });

    }

}
