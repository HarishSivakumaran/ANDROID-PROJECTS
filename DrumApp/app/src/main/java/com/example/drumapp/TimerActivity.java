package com.example.drumapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    TextView textView,done,mnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        textView=findViewById(R.id.textView);
        done=findViewById(R.id.done);
        mnumber=findViewById(R.id.mnumber);
        mediaPlayer = MediaPlayer.create(this,R.raw.drumsound7);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mnumber.setText(""+(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                mnumber.setText("0");
                done.setText("DONE !!");
                mediaPlayer.start();;

            }
        }.start();
    }
}
