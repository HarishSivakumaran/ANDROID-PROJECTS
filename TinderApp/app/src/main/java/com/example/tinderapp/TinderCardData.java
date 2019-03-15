package com.example.tinderapp;

public class TinderCardData {

    private int mImageId;
    private String mText;


    public int getmImageId() {
        return mImageId;
    }

    public String getmText() {
        return mText;
    }

    public TinderCardData(int imageId, String text){

        mImageId=imageId;

        mText=text;


    }

}