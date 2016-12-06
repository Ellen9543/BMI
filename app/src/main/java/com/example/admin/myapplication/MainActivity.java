package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;


import static com.example.admin.myapplication.R.id.surHeight;
import static com.example.admin.myapplication.R.id.surName;
import static com.example.admin.myapplication.R.id.surWeight;

public class MainActivity extends AppCompatActivity {

    EditText height,weight,name;
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        application=(MyApplication)getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(surName);
        height=(EditText)findViewById(surHeight);
        weight=(EditText)findViewById(surWeight);

        if(application.getCounter()==1){
            EditText editText2 = (EditText) this.findViewById(R.id.surName);
            EditText editText3 = (EditText) this.findViewById(R.id.surHeight);
            EditText editText4 = (EditText) this.findViewById(R.id.surWeight);

            //new一個Bundle物件，透過Bundle 接收MainActiviy傳遞過來的資料
            Bundle bundle = this.getIntent().getExtras();
            String msg2 = bundle.getString("name");
            String msg3 = bundle.getString("height");
            String msg4 = bundle.getString("weight");

            //setText→設定文字內容
            editText2.setText(msg2);
            editText3.setText(msg3);
            editText4.setText(msg4);
        }
    }


    public void onclick1(View v){

        if(name.getText().toString().matches("")||height.getText().toString().matches("")||weight.getText().toString().matches("")){
            return;
        }else {
            application.setCounter(1);
            Intent it = new Intent(this, Main2Activity.class);

            Bundle bundle1 = new Bundle();
            bundle1.putString("name", name.getText().toString());
            bundle1.putString("height", height.getText().toString());
            bundle1.putString("weight", weight.getText().toString());

            it.putExtras(bundle1);
            startActivity(it);

        }
    }

    public void onclick2(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Main3Activity.class);

        Bundle bundle2 = new Bundle();
        bundle2.putInt("main3",1);
        bundle2.putString("name","");
        intent.putExtras(bundle2);
        startActivity(intent);

        }



    @Override
    public   void   onBackPressed() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}




