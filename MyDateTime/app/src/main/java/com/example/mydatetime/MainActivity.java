package com.example.mydatetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView datetext;
    TextView timetext;
    DatePicker datePicker;
    TimePicker timePicker;
    Button gototime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datetext=findViewById(R.id.datetext);
        datePicker=findViewById(R.id.datepicker);
        gototime=findViewById(R.id.gototime);

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                datetext.setText("DATE IS "+ dayOfMonth + "/" +(monthOfYear+1) + "/" +year );
            }
        });

        gototime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.time);
                timePicker=findViewById(R.id.timepicker);
                timetext=findViewById(R.id.timetext);


                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                        timetext.setText("TIME IS  " + hourOfDay +":"+minute);

                    }
                });
            }
        });

    }
}
