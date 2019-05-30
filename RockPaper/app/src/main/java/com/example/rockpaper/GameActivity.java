package com.example.rockpaper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GameActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button button;
    FirebaseAuth.AuthStateListener authStateListener;
    TextView textView;
    Button rBtn,pBtn,sBtn;
    FirebaseDatabase database;
    DatabaseReference rootRef;
    DatabaseReference gameRef;


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String text = dataSnapshot.getValue().toString();
                textView.setText(text);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button=findViewById(R.id.btn);

        mAuth=FirebaseAuth.getInstance();

        textView=findViewById(R.id.textGame);

        rBtn=findViewById(R.id.rbtn);

        pBtn=findViewById(R.id.button2);

        sBtn=findViewById(R.id.scibtn);

        //add to app level gradle   implementation 'com.google.firebase:firebase-database:16.1.0'

         database = FirebaseDatabase.getInstance();

         rootRef = database.getReference();


         gameRef=rootRef.child("game");



        rBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("ROCK");
                Log.d("tag", "clicked here ");
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("PAPER");
            }
        });

        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameRef.setValue("SCISSOR");
            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });

        authStateListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(GameActivity.this, MainActivity.class));
                }
            }
        };


    }
}
