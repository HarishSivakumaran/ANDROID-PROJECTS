package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button dol,euro,yen,btc,cent,pound,cruzeiro,french,german;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView=findViewById(R.id.outputtext);
        editText=findViewById(R.id.editText);
        dol=findViewById(R.id.dollar);
        euro=findViewById(R.id.euro);
        yen=findViewById(R.id.yen);
        btc=findViewById(R.id.bitcoin);
        cent=findViewById(R.id.cent);
        pound=findViewById(R.id.pound);
        cruzeiro=findViewById(R.id.CRUZEIRO);
        french=findViewById(R.id.french);
        german=findViewById(R.id.germanpenny);



                dol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String a = editText.getText().toString();

                        if(TextUtils.isEmpty(a)){
                            editText.setError("NO INPUT");
                        } else{
                            Double b,c;
                            b= Double.parseDouble(a);
                            c= b * 0.014;
                            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                            textView.setText(decimalFormat.format(c));


                        }
            }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.013;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 1.59;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.0000037;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        cent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 100;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.014;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        cruzeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.011;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        french.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.014;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editText.getText().toString();

                if(TextUtils.isEmpty(a)){
                    editText.setError("NO INPUT");
                } else{
                    Double b,c;
                    b= Double.parseDouble(a);
                    c= b * 0.014;
                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    textView.setText(decimalFormat.format(c));


                }
            }
        });
    }
}
