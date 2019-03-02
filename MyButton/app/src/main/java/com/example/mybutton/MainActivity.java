package com.example.mybutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button vin;
    Button sai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vin=findViewById(R.id.mybtn2);
        sai=findViewById(R.id.mybtn);
        vin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","vinayagar");
            }
        });
        sai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test","SAIBABA");
            }
        });
    }
    public void Guru(View v)
    {
        Log.d("3rdbtn","guru thunai");
    }
}
