package com.example.stockyourfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddFridge extends AppCompatActivity {

    private Button Add;
    private EditText editText;
    private TextView textView;
    public static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fridge);

        Add=(Button) findViewById(R.id.button2);
        textView=(TextView) findViewById(R.id.textView8);
        editText=(EditText) findViewById(R.id.editTextTextPersonName3);
        Bundle bn=getIntent().getExtras();
        String name=bn.getString("message");
        id=bn.getInt("id");
        if(name.equals("Add Fridge"))
        {
            textView.setText(String.valueOf(name));
            Add.setText("ADD");
        }
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFridge();
            }
        });
    }
    public void createFridge()
    {
        String text=editText.getText().toString();
        Intent intent=new Intent(this,FridgePage.class);
        intent.putExtra("text",text);
        startActivity(intent);
    }
}