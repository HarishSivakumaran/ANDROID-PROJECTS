package com.example.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText mEmail,mPasswd;
    public FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(MainActivity.this,"ALREADY LOGGED IN",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"Not LOGGED IN",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change the google dependencies 'com.google.gms:google-services:4.2.0'

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        button=findViewById(R.id.button);
        mEmail=findViewById(R.id.editText);
        mPasswd=findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegister();
            }
        });
    }


    public void onRegister(){

         String email=mEmail.getText().toString();
         String password=mPasswd.getText().toString();
        if(TextUtils.isEmpty(mEmail.getText().toString()) ||TextUtils.isEmpty( mPasswd.getText().toString())){

            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("tag", "createUserWithEmail:success");
                            Toast.makeText(MainActivity.this,"SUCCESS ",Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this,"FAILED LOGIN",Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }
}
