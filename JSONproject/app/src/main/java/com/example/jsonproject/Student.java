package com.example.jsonproject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Student {


    public Student(String mName, String mEmail, int courseCount, Course course, ArrayList<Video> videoList) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.courseCount = courseCount;
        this.course = course;
        this.videoList = videoList;
    }

    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("coursecount")
    private int courseCount;
    @SerializedName("course")
    private Course course;
    @SerializedName("videos")
    private ArrayList<Video> videoList;



}
