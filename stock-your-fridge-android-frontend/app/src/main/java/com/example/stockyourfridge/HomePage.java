package com.example.stockyourfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    private Button AddFridge;
    private Button ViewFridge;
    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Bundle bn=getIntent().getExtras();
        id=bn.getInt("id");
        AddFridge=(Button) findViewById(R.id.btnAddFridge);
        ViewFridge=(Button) findViewById(R.id.btnViewFridge);


        AddFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddFridge();
            }
        });
        ViewFridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewFridge();
            }
        });
    }
    public void openAddFridge(){
        Intent intent=new Intent(HomePage.this,AddFridge.class);
        intent.putExtra("message","Add Fridge");
        intent.putExtra("id",id);
        startActivity(intent);
    }
    public void openViewFridge(){
        Intent intent=new Intent(HomePage.this,ViewFridge.class);
        startActivity(intent);
    }
}
