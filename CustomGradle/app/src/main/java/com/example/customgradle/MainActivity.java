package com.example.customgradle;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void ShowToast(View view)
    {
        switch (view.getId())
        {
            case R.id.errorMessage:
                Toasty.error(this,"LOGIN FAILED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.successMessage:
                Toasty.success(this,"LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.infoMessage:
                Toasty.info(this,"INFORMATION", Toast.LENGTH_SHORT).show();
                break;
            case R.id.warningMessage:
                Toasty.warning(this,"OoppssS!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageMessage:
                Toasty.normal(this,"SAIBABA THUNAI", Toast.LENGTH_SHORT, ContextCompat.getDrawable(this,R.drawable.ic_cloud)).show();
                break;
        }
    }
}
