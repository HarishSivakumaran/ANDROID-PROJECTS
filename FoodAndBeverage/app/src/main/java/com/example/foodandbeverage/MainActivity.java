package com.example.foodandbeverage;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    LinearLayout imageView;
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView2;
    //ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    Button orderbtn;
    SeekBar seekBar;
    Button rating;
    String food1,beverage1;
    ArrayAdapter<String> arrayAdapter,arrayAdapter2;


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
        //ArrayAdapter<St> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,food);
        //autoCompleteTextView.setAdapter(arrayAdapter);
        //ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,beverage);
        //autoCompleteTextView2.setAdapter(arrayAdapter2);

          arrayAdapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,food);
          arrayAdapter2 = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,beverage);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter2);
         imageView.setBackgroundResource(R.drawable.animatedimageview);
       animationDrawable = (AnimationDrawable) imageView.getBackground();
     animationDrawable.setExitFadeDuration(3000);
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



                Intent intent = new Intent(MainActivity.this,RatingActivity.class);
                Bundle main_Actvity_bundle = new Bundle();
                main_Actvity_bundle.putString("foodval",food1);
                main_Actvity_bundle.putString("beverageval",beverage1);
                intent.putExtras(main_Actvity_bundle);
                startActivity(intent);

            }
        });


        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                food1=autoCompleteTextView.getText().toString();
                beverage1=autoCompleteTextView2.getText().toString();
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

