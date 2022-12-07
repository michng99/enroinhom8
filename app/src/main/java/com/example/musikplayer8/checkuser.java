package com.example.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class checkuser extends AppCompatActivity {

    EditText username;
    Button reset, cancel;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkuser);

        username = (EditText) findViewById(R.id.user);
        reset = (Button) findViewById(R.id.RSp);
        cancel = (Button) findViewById(R.id.cancel);
        DB = new DBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();

                Boolean checkuser = DB.checkusername(user);
                if (checkuser==true){
                    Intent intent = new Intent(getApplicationContext(),changePassword.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(checkuser.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}