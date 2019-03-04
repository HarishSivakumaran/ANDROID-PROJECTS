package com.example.truthordare;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    Button spin;
    ImageView imageView;
    ConstraintLayout constraintLayout;
    int lastdirection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin=findViewById(R.id.spin_id);
        imageView=findViewById(R.id.imageView);
        constraintLayout=findViewById(R.id.layout_root);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

    }
    public void spinMethod(View view){
        int newdirection =random.nextInt(3000)+720;
        int pivotx =imageView.getWidth()/2;
        int pivoty=imageView.getHeight()/2;
        Animation rotate =new RotateAnimation(lastdirection,newdirection,pivotx,pivoty);
        lastdirection=newdirection;
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        imageView.startAnimation(rotate);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                spin.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spin.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
