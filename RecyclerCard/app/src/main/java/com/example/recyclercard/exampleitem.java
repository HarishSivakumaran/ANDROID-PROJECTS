package com.example.recyclercard;

public class exampleitem {

    private  int mImageResource;
    private  String mText;

    public  exampleitem(int imageResource,String text){

        mImageResource = imageResource;
        mText=text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
