package com.example.stockyourfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddAisle extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aisle);

        button=(Button) findViewById(R.id.button5);
        editText=(EditText) findViewById(R.id.editTextTextPersonName6);
        textView=(TextView) findViewById(R.id.textView11);
        Bundle bn=getIntent().getExtras();
        String name=bn.getString("text");
        textView.setText(name.toUpperCase());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFridgePage();
            }
        });
    }
    public void gotoFridgePage(){
        Intent intent=new Intent(this, AddItem.class);
        intent.putExtra("text",editText.getText().toString());
        startActivity(intent);
    }
}