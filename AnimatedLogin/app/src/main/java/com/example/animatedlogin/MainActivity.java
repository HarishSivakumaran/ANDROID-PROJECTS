package com.example.animatedlogin;

import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    Button login_btn;
    Button signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.layout_root);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        login_btn=findViewById(R.id.login);
        signup_btn=findViewById(R.id.signup);


    }


    public void login(View view)  {

        login_btn.setEnabled(false);
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                login_btn.setEnabled(true);

            }
        }.start();

    }
    public void signUp(View view)  {
//        long time=3000;
        signup_btn.setEnabled(false);
        new CountDownTimer(3000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                signup_btn.setEnabled(true);

            }
        }.start();

//        wait(time);
//        signup.setEnabled(true);

    }

}
