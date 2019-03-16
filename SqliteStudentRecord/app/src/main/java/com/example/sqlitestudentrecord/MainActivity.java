package com.example.sqlitestudentrecord;

import android.database.Cursor;
import android.support.v4.database.CursorWindowCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText name,id,email,cc;
    Button add,update,view,viewAll,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB=new DatabaseHelper(MainActivity.this);

        name=findViewById(R.id.editText_name);
        id=findViewById(R.id.editText_id);
        cc=findViewById(R.id.editText_CC);
        email=findViewById(R.id.editText_email);

        add=findViewById(R.id.button_add);
        update=findViewById(R.id.button_update);
        view=findViewById(R.id.button_view);
        viewAll=findViewById(R.id.button_viewAll);
        delete=findViewById(R.id.button_delete);

        addData();
        getData();
        getAllData();
        updateData();
        deleteData();


    }

    public void addData(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean bInsert=myDB.insertData(name.getText().toString(),email.getText().toString(),cc.getText().toString());

                if(bInsert==true){

                    Toast.makeText(MainActivity.this,"DATA INSERTED",Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this,"SOMETHINGH WENT WRONG",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    public void getData(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = null;


                if(TextUtils.isEmpty(id.getText().toString())){

                    id.setError("NO ID");
                    return;

                }


               Cursor cursor = myDB.getData(id.getText().toString());

                if(cursor.moveToNext()){
                    data="ID : "+cursor.getString(0)+ "\n" +"NAME : "+cursor.getString(1)+ "\n" +"EMAIL : "+cursor.getString(2)+ "\n" +"COURSE COUNT : "+cursor.getString(3);

                }
                showMessage("DATA",data);


            }
        });

    }

    public void getAllData(){

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer = new StringBuffer();

                Cursor cursor = myDB.getAllData();

                if(cursor.getCount()==0){
                    showMessage("ERROR","NO DATA PRESENT");
                    return;
                }

                while (cursor.moveToNext()){

                    buffer.append("ID: "+cursor.getString(0)+"\n");
                    buffer.append("NAME: "+cursor.getString(1)+"\n");
                    buffer.append("EMAIL: "+cursor.getString(2)+"\n");
                    buffer.append("COURSE COUNT: "+cursor.getString(3)+"\n\n");

                }

                showMessage("DATA",buffer.toString());
            }
        });

    }

    public void updateData(){

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(id.getText().toString())){

                    id.setError("EMPTY ID");
                    return;
                }

                boolean isUpdate = myDB.updateData(id.getText().toString(),
                        name.getText().toString(),
                        email.getText().toString(),
                        cc.getText().toString());

                if(isUpdate){

                    Toast.makeText(MainActivity.this,"UPDATE SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(MainActivity.this,"UPDATE UNSUCCESSFUL",Toast.LENGTH_SHORT).show();


                }
            }
        });

    }

    public void deleteData(){

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(id.getText().toString())){

                    id.setError("EMPTY ID");
                    return;
                }

                Integer deleted = myDB.deleteData(id.getText().toString());

                if(deleted>0){
                    Toast.makeText(MainActivity.this,"DELETE SUCCESSFUL",Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this,"DELETE UNSUCCESSFUL",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }




    private  void showMessage(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }
}
