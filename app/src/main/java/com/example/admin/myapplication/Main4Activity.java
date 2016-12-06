package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void onclick(View v) {
        Intent intent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "");
        bundle1.putString("height", "");
        bundle1.putString("weight", "");
        intent.putExtras(bundle1);
        intent.setClass(Main4Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
