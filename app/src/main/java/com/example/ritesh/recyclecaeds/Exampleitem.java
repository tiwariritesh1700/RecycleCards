package com.example.ritesh.recyclecaeds;

public class Exampleitem {

    private int mImageResource;
    private String  mtext;

    public Exampleitem (int Imageresource,String Text){

        mImageResource=Imageresource;
        mtext=Text;
    }

    public int getmImageResource(){

        return mImageResource;
    }

    public String getText(){
        return mtext;
    }
}
