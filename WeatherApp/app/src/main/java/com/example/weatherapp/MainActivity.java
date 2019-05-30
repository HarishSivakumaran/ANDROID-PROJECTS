package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    RequestQueue requestQueue;

    //https://api.openweathermap.org/data/2.5/weather?q=manipal&appid=fba4f407bbf5fd2a02217c65b50bf047

    String baseURl ="https://api.openweathermap.org/data/2.5/weather?q=";
    String apiId="&appid=fba4f407bbf5fd2a02217c65b50bf047";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      button=findViewById(R.id.button);
    editText=findViewById(R.id.editText);
     textView=findViewById(R.id.text);

     requestQueue= Volley.newRequestQueue(MainActivity.this);

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(TextUtils.isEmpty(editText.getText().toString())){

                 editText.setError("NO CITY");
                 return;
             }

             String URL = baseURl+editText.getText().toString()+apiId;
             Log.d("test", "onClick: "+URL);

             JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                 @Override
                 public void onResponse(JSONObject response) {

                     try {
                        JSONArray jsonArray = response.getJSONArray("weather");
                         JSONObject jsonObject= jsonArray.getJSONObject(0);
                         String result = jsonObject.getString("main");
                         textView.setText(result);

                     } catch (JSONException e) {
                         e.printStackTrace();
                     }


                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {

                     Toast.makeText(MainActivity.this,"NETWORK PROBLEM",Toast.LENGTH_SHORT).show();

                 }
             });


             requestQueue.add(jsonObjectRequest);
         }
     });

    }
}
