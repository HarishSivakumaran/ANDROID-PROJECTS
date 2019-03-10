package com.example.drumapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

//    ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    MediaPlayer m1,m2,m3,m4,m5,m6,m7,m8,m9;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1=MediaPlayer.create(this,R.raw.drumsound1);
        m2=MediaPlayer.create(this,R.raw.drumsound2);
        m3=MediaPlayer.create(this,R.raw.drumsound3);
        m4=MediaPlayer.create(this,R.raw.drumsound4);
        m5=MediaPlayer.create(this,R.raw.drumsound5);
        m6=MediaPlayer.create(this,R.raw.drumsound6);
        m7=MediaPlayer.create(this,R.raw.drumsound7);
        m8=MediaPlayer.create(this,R.raw.drumsound8);
        m9=MediaPlayer.create(this,R.raw.drumsound9);


    }
    public  void click(View view){

        id = view.getId();

        switch (id){

            case R.id.button1 : m1.start();
            break;
            case R.id.button2 : m2.start();
                break;
            case R.id.button3 : m3.start();
                break;
            case R.id.button4 : m4.start();
                break;
            case R.id.button5 : m5.start();
                break;
            case R.id.button6 : m6.start();
                break;
            case R.id.button7 : m7.start();
                break;
            case R.id.button8 : m8.start();
                break;
            case R.id.button9 : m9.start();
                break;



        }


    }
}
