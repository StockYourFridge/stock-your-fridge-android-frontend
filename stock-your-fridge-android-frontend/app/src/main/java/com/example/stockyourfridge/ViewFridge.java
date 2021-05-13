package com.example.stockyourfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewFridge extends AppCompatActivity {
    private Button AddFridges;
    private TextView textView;
    ListView listView;

    String[] listItem;



  //  public static List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fridge);
        AddFridges=(Button) findViewById(R.id.btnAddFridges);
        textView=(TextView)findViewById(R.id.textView6);

        listView=findViewById(R.id.list);
        listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();

            }
        });

//        AddFridges.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//       //         OpenAddFridges();
//
//            }
//        });
    }
//    public void OpenAddFridges(){
//        Intent intent=new Intent(ViewFridge.this,AddFridge.class);
//        startActivity(intent);
//    }
}