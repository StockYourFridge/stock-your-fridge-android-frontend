package com.example.stockyourfridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Index extends AppCompatActivity {

    private Button Login;
    private Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=(Button) findViewById(R.id.btnLogin);
        SignUp=(Button) findViewById(R.id.btnSignUp);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openSignUpActivity();
            }
        });
    }
       public void openSignUpActivity(){
           Intent intent=new Intent(Index.this,SignUp.class);
           startActivity(intent);
       }
       public void openLoginActivity(){
           Intent intent=new Intent(Index.this,Login.class);
           startActivity(intent);
       }
}