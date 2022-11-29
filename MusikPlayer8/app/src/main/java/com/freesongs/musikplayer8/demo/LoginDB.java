package com.freesongs.musikplayer8.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.freesongs.musikplayer8.R;

public class LoginDB extends AppCompatActivity {

    EditText username,password;
    Button btnlogin,btnRegister;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_db);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String users = username.getText().toString();
                String passs = password.getText().toString();

                if (users.equals("")||passs.equals(""))
                    Toast.makeText(LoginDB.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(users, passs);
                    if (checkuserpass==true){
                        Toast.makeText(LoginDB.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginDB.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginDB.this, MainActivity.class));
            }
        });
    }

}