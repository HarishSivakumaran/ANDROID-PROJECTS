package com.example.custom_toast_recap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Hbd(View v)
    {
        //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        Show_toast("HBD!!!!!");

    }
    public void Show_toast(String k)
    {

        LayoutInflater inflater=getLayoutInflater();
        View view;
        view = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.Toast_root));
        TextView t =view.findViewById(R.id.text_toast);
        t.setText(k);
        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }
    public void Android(View v)
    {
        show_and_toast();
    }
    public void  show_and_toast()
    {
        //LayoutInflater layoutInflater = getLayoutInflater();
        View view=getLayoutInflater().inflate(R.layout.toast_android,(ViewGroup) findViewById(R.id.toast_root_android));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,20);

        toast.setView(view);
        toast.show();
    }

}
