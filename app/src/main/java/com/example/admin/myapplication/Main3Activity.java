package com.example.admin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity {
   // private ArrayList<String> arylistName;
    private ArrayList<String> arylistData;
    private ListView listView;
   private ArrayAdapter<String> listAdapter;

    Integer main3;
    String a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = this.getIntent().getExtras();
        a1=bundle.getString("name");
        main3 = bundle.getInt("main3");

          ArrayList<String> arylistData = new ArrayList<>();

            if (main3 == 2) {
                arylistData.add(a1);
            }
                listAdapter = new ArrayAdapter<String>(Main3Activity.this, android.R.layout.simple_list_item_1, arylistData);
                listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);


        Bundle bundle = this.getIntent().getExtras();

        main3 = bundle.getInt("main3");
        a1=bundle.getString("name");

        if(main3==1) {
           

            listView.setAdapter(listAdapter);
        }else if(main3==2){


            listAdapter.insert(a1,0);
            //listAdapter.notifyDataSetChanged();

            listView.setAdapter(listAdapter);
        }

    }


    public void onclick(View v){
        Intent intent = new Intent();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name","");
        bundle1.putString("height","");
        bundle1.putString("weight","");
        intent.putExtras(bundle1);
        intent.setClass(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
