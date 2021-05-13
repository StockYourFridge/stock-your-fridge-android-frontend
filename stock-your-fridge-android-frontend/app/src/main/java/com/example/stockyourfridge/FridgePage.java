package com.example.stockyourfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FridgePage extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_page);
        button=(Button)findViewById(R.id.button4);
        textView=(TextView)findViewById(R.id.textView4);

        Bundle bn=getIntent().getExtras();
        name=bn.getString("text");
        if(!name.equals("")) {
            textView.setText(name.toUpperCase());
        }
        else
            openAddFridge();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencreateAisle();
            }
        });
    }
    public void opencreateAisle(){
        Intent intent = new Intent(FridgePage.this,AddAisle.class);
        intent.putExtra("text",name);
        startActivity(intent);
    }
    public void openAddFridge() {
        Intent intent = new Intent(FridgePage.this, AddFridge.class);
        startActivity(intent);
    }
}