package com.example.devotion;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
    }
    public void login_method(View view)
    {
        login.setEnabled(false);
        Toasty.success(this,"LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onFinish() {
                login.setEnabled(true);

            }
        }.start();

    }

}
