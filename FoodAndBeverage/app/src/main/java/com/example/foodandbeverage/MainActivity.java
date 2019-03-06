package com.example.foodandbeverage;

import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    float a;
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView2;
    //ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    Button orderbtn;
    SeekBar seekBar;
    Button rating;
    RatingBar ratingBar;
    Button submit;
    TextView textView;
    ConstraintLayout rating_layout;
    String[] food = new String[]{"aroma","bagel","batter","beans","beer","biscuit","bread","broth","burger","butter","cake","candy","caramel","caviar","cheese","chili","chocolate","cider","cobbler","cocoa","coffee","cookie","cream","croissant","crumble","cuisine","curd","dessert","dish","drink","eggs","entree","filet","fish","flour","foie","gras","food","glaze","grill","hamburger","ice","juice","ketchup","kitchen","lard","liquor","margarine","marinade","mayo","mayonnaise","meat","milk","mousse","muffin","mushroom","noodle","nut","oil","olive","omelette","pan","pasta","paste","pastry","pie","pizza","plate","pot","poutine","pudding","raclette","recipe","rice","salad","salsa","sandwich","sauce","seasoning","skillet","soda","soup","soy","spice","steak","stew","syrup","tartar","taste","tea","toast","vinegar","waffle","water","wheat","wine","wok","yeast","yogurt"};
    String[] beverage = new String[]{"apple","banana","pineapple","lemon","beer","whiskey","grape"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2=findViewById(R.id.autoCompleteTextView2);
        imageView=findViewById(R.id.imageView);
        orderbtn=findViewById(R.id.button);
        seekBar=findViewById(R.id.seekbar);
        rating=findViewById(R.id.rating);
        //constraintLayout=findViewById(R.id.layout_root);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,food);
        autoCompleteTextView.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,beverage);
        autoCompleteTextView2.setAdapter(arrayAdapter2);
        imageView.setBackgroundResource(R.drawable.animatedimageview);
       animationDrawable = (AnimationDrawable) imageView.getBackground();
     animationDrawable.setExitFadeDuration(2000);
      animationDrawable.setEnterFadeDuration(3000);
        animationDrawable.start();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                orderbtn.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {

                setContentView(R.layout.rating);
                submit=findViewById(R.id.submit);
                ratingBar=findViewById(R.id.ratingBar);
                textView=findViewById(R.id.textView);
                a= ratingBar.getRating();
                 submit.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(a<2.5){
                             textView.setText("rating : good");
                         }
                         else{
                             textView.setText("rating:very good");
                         }



                     }
                 });

            }
        });


        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orderbtn.setEnabled(false);

                Toasty.normal(getApplicationContext(),"PLEASE WAIT", Toast.LENGTH_SHORT).show();

                new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {

                        orderbtn.setEnabled(true);

                        Toasty.success(getApplicationContext(),"ORDER PLACED ", Toast.LENGTH_SHORT).show();


                    }
                }.start();
            }
        });

    }
}

