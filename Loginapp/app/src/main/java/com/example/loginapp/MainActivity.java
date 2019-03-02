package com.example.loginapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Login(View v)
    {
        /*Context c = getApplicationContext();
        CharSequence name = "WELCOME!!";
        int duration = Toast.LENGTH_SHORT;
        Toast t = Toast.makeText(c,name,duration);
        t.show();*/
        Toast.makeText(this,"WELCOME!!",Toast.LENGTH_SHORT).show();


    }
    public void Register(View c)
    {
        Context c = getApplicationContext();
        CharSequence name = "PLEASE WAIT ;-)";
        int duration = Toast.LENGTH_LONG;
        Toast h = Toast.makeText(c,name,duration);
        h.show();

    }
}
