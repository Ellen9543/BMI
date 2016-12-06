package com.example.admin.myapplication;

import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
   // private ArrayList<String> arylistName;
    float h,w,r,dh;
    Intent it;
    String msg7,msg3,msg4,d,arylistName;
    TextView height,weight,name;
    GestureDetector gesture;
    Handler handler;



    OnGestureListener listener = new OnGestureListener(){

        @Override
        public boolean onDown(MotionEvent e) {
            // TODO Auto-generated method stub

            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            // TODO Auto-generated method stub

            if ((e1.getX() - e2.getX()) < -50) {
                Intent intent = new Intent();

                Bundle bundle1 = new Bundle();
                bundle1.putString("name", msg7);
                bundle1.putString("height",msg3);
                bundle1.putString("weight",msg4);
                intent.putExtras(bundle1);

                intent.setClass(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                // 設定切換的滑頁動畫，從左邊進入，右邊退出
                overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                Main2Activity.this.finish();
                return true;
            }else {
                return false;
            }
        }

        @Override
        public void onLongPress(MotionEvent e) {
            // TODO Auto-generated method stub


        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // TODO Auto-generated method stub
            return false;
        }};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //初始化變化
        name = (TextView) findViewById(R.id.TextView7);
        height = (TextView) findViewById(R.id.TextView3);
        weight = (TextView) findViewById(R.id.TextView4);

        //創建一個GestureDetector對象
        gesture = new GestureDetector(this,listener,handler,true);

        TextView TextView7 = (TextView)this.findViewById(R.id.TextView7);
        TextView TextView3 = (TextView)this.findViewById(R.id.TextView3);
        TextView TextView4 = (TextView)this.findViewById(R.id.TextView4);
        TextView TextView5 = (TextView)this.findViewById(R.id.TextView5);
        TextView TextView6 = (TextView)this.findViewById(R.id.TextView6);


        Bundle bundle = this.getIntent().getExtras();

        msg7 = bundle.getString("name");

        msg3 = bundle.getString("height");
        h = Float.parseFloat(msg3);

        msg4 = bundle.getString("weight");
        w = Float.parseFloat(msg4);

        h=h/100;
        dh=h*h;
        r=w/dh;

        TextView7.setText(msg7);
        TextView3.setText(msg3+"cm");
        TextView4.setText(msg4+"kg");
        TextView5.setText(Float.toString(r));

        if(r<18.5) {
            TextView6.setText("體重過輕");
            d = "體重過輕";
        }else if (18.5 <= r && r < 24) {
            TextView6.setText("正常範圍");
            d = "正常範圍";
        }else if (24 <= r && r < 27) {
            TextView6.setText("過重");
            d = "過重";
        }else if (27 <= r && r < 30) {
            TextView6.setText("輕度肥胖");
            d = "輕度肥胖";
        }else if (30 <= r && r < 35) {
            TextView6.setText("中度肥胖");
            d = "中度肥胖";
        }else if (r >= 35) {
            TextView6.setText("重度肥胖");
            d ="重度肥胖";
        }

    }

    //按button回到上一頁
    public void onclick1(View v){
        Intent intent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", msg7);
        bundle1.putString("height",msg3);
        bundle1.putString("weight",msg4);
        intent.putExtras(bundle1);
        intent.setClass(Main2Activity.this, MainActivity.class);
        startActivity(intent);

    }
    //加入追蹤，ListView
    public void onclick2(View v){

        arylistName=(msg7+"  "+h+"m"+"  "+w+"kg"+"  BMI:"+r+"    "+d);
        Intent intent = new Intent();

        intent.setClass(Main2Activity.this, Main3Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name",arylistName);
        bundle.putInt("main3",2);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

       // back();

        Intent backIntent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "");
        bundle1.putString("height", "");
        bundle1.putString("weight", "");
        backIntent.putExtras(bundle1);
        backIntent.setClass(Main2Activity.this, MainActivity.class);
        startActivity(backIntent);


    }
/*
    public void back(){
        Intent backIntent = new Intent();
        backIntent.setClass(Main2Activity.this, MainActivity.class);
        startActivity(backIntent);
    }*/


    @Override
    public boolean onTouchEvent(MotionEvent event){

        //detector就是上面創建的對象
        return gesture.onTouchEvent(event);

    }



}
