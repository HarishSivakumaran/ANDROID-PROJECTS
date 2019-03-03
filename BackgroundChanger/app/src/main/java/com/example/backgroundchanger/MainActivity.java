package com.example.backgroundchanger;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random rand = new Random();
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.mainlayout_root);
    }
    public void btn(View view)
    {
        int colour= Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        layout.setBackgroundColor(colour);

    }
}
