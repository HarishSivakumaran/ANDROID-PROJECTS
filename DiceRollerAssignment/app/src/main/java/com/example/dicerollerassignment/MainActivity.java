package com.example.dicerollerassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
 private Random rand_num =new Random();
//    private Random rand_num2 =new Random();
 ImageView dice1 ;
    ImageView dice2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice1 =findViewById(R.id.imageView);
        dice2 =findViewById(R.id.imageView2);
    }
    public void btn(View view)
    {
        int n1= rand_num.nextInt(6)+1;
        int n2= rand_num.nextInt(6)+1;
        switch (n1)
        {
            case 1:
                dice1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice1.setImageResource(R.drawable.dice6);
                break;
        }
        switch (n2)
        {
            case 1:
                dice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice2.setImageResource(R.drawable.dice6);
                break;
        }

    }
}
