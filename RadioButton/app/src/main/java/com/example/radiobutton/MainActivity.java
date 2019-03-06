package com.example.radiobutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.layout_root);
        radioGroup=findViewById(R.id.rgroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.darkbtn:relativeLayout.setBackgroundColor(Color.parseColor("#2C3335"));
                    break;
                    case R.id.light:relativeLayout.setBackgroundColor(Color.parseColor("#FAC42F"));
                        break;
                    case R.id.green:relativeLayout.setBackgroundColor(Color.parseColor("#7CEC9F"));
                        break;
                }
            }
        });
    }
}
