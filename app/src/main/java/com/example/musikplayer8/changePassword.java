package com.example.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class changePassword extends AppCompatActivity {

    TextView username;
    EditText oldpass, newpass;
    Button updatepass, cancel;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        username = (TextView) findViewById(R.id.username_reset_text);
        oldpass = (EditText) findViewById(R.id.oldP);
        newpass = (EditText) findViewById(R.id.newP);
        updatepass = (Button) findViewById(R.id.UD);
        cancel = (Button) findViewById(R.id.cancel1);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("username"));

        updatepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String password = oldpass.getText().toString();
                String repassword = newpass.getText().toString();
                if (password.equals(repassword)){
                Boolean checkpasswordupdate = DB.updatepassword(user,password);
                if (checkpasswordupdate==true){
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(changePassword.this, "Password update successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(changePassword.this, "Password not update", Toast.LENGTH_SHORT).show();
                }

                }else {
                    Toast.makeText(changePassword.this, "Password not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),checkuser.class);
                startActivity(intent);

            }
        });
    }
}