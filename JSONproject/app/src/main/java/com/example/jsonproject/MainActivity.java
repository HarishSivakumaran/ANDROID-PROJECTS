package com.example.jsonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
//        Student student = new Student("harish","harish@gmail.com",7);
//        String json = gson.toJson(student);
//
////        Log.d("test",json);
//
//        String json = "{\"coursecount\":7,\"email\":\"harish@gmail.com\",\"name\":\"harish\"}";
//
//        Student student = gson.fromJson(json,Student.class);
//
//        Log.d("test",student.toString());
//        Course course = new Course("android",3);
//        ArrayList<Video> videoslist = new ArrayList<>();
//        videoslist.add(new Video("intro",5));
//        videoslist.add(new Video("da",5));
//        videoslist.add(new Video("asa",5));
//        videoslist.add(new Video("dca",5));
//        videoslist.add(new Video("da",5));
//
//        Student student = new Student("harish","hr@hari.com",7,course,videoslist);
//
//        String json = gson.toJson(student);
//
        String json ="{\"course\":{\"courseName\":\"android\",\"courseType\":3},\"coursecount\":7,\"email\":\"hr@hari.com\",\"name\":\"harish\",\"videos\":[{\"mDuration\":5,\"mVideoName\":\"intro\"},{\"mDuration\":5,\"mVideoName\":\"da\"},{\"mDuration\":5,\"mVideoName\":\"asa\"},{\"mDuration\":5,\"mVideoName\":\"dca\"},{\"mDuration\":5,\"mVideoName\":\"da\"}]}";
//        Log.d("test",json);

        Student xStudent = gson.fromJson(json,Student.class);

        Log.d("test",xStudent.toString());

    }
}
