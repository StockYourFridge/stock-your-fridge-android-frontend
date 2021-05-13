package com.example.stockyourfridge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    private static int id;
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private Button button;
    private TextView mssg;
    JsonPlaceholderApi jsonPlaceholderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=(EditText)findViewById(R.id.editTextTextPersonName);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress);
        password=(EditText)findViewById(R.id.editTextTextPassword);
        confirm_password=(EditText)findViewById(R.id.editTextTextPassword2);
        button=(Button)findViewById(R.id.button3);
        mssg=(TextView)findViewById(R.id.textView_mssg);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://localhost:9090/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceholderApi=retrofit.create(JsonPlaceholderApi.class);
        addUser();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });
    }
    public void goToHome()
    {
        if(password.equals(confirm_password))
        {
            Intent intent = new Intent(SignUp.this, HomePage.class);
            intent.putExtra("id",id);
            startActivity(intent);
        }
        else{
            Toast.makeText(SignUp.this, "Check Your Password", Toast.LENGTH_SHORT).show();
        }
    }
    private void addUser(){
        user user=new user(name.getText().toString(),password.getText().toString(),email.getText().toString(),true);
        Call<user> call=jsonPlaceholderApi.addUser(user);
        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                if(!response.isSuccessful())
                {
                    mssg.setText("code :"+response.code());
                    return;
                }
        //        user userResponse=response.body();
//                String content = "";
//                content +="Code: "+response.body()+  "\n";
//                content += "ID: " + postResponse.getId() + "\n";
//                content += "User ID: " + postResponse.getUserId() + "\n";
//                content += "Title: " + postResponse.getTitle() + "\n";
//                content += "Text: " + postResponse.getText() + "\n\n";
            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {
                mssg.setText(t.getMessage());
            }
        });
    }
}