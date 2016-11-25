package com.example.admin.myapplication;

import android.app.Application;

public class MyApplication extends  Application{
    private int counter;

    public int getCounter(){
        return counter;
    }
    public  void setCounter(int counter){
        this.counter = counter;
    }

}
