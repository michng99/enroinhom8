package com.freesongs.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.freesongs.musikplayer8.DAO.DaoUser;
import com.freesongs.musikplayer8.Model.User;

public class Login extends AppCompatActivity {

    DaoUser daoUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText edtusername = findViewById(R.id.edtusername);
        EditText edtpassword = findViewById(R.id.edtpassword);
        Button btnlogin = findViewById(R.id.btnlogin);
        Button btndangki = findViewById(R.id.btndangki);
        daoUser = new DaoUser(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtusername.getText().toString();
                String passwordd = edtpassword.getText().toString();
                if (username.equals("")  || passwordd.equals(""))
                {
                    Toast.makeText(Login.this, "Chưa Nhập Username Hoặc Password", Toast.LENGTH_LONG).show();
                    return;
                }
                User user = daoUser.Login(username, passwordd);
                if (user==null)
                {
                    Toast.makeText(Login.this,"Sai Username Hoặc Password",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    Toast.makeText(Login.this,"Đăng Nhập Thành Công",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btndangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Login.this);
                dialog.setContentView(R.layout.dialog_dangki);
                dialog.show();
                EditText usernamee = dialog.findViewById(R.id.userdangki);
                EditText passwordd = dialog.findViewById(R.id.passworddangki);
                Button dangki = dialog.findViewById(R.id.dangki);
                dangki.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Username = usernamee.getText().toString();
                        String Password = passwordd.getText().toString();
                        if (Password.equals("")  || Username.equals(""))
                        {
                            Toast.makeText(Login.this, "Chưa Nhập Username Hoặc Password", Toast.LENGTH_LONG).show();
                            return;
                        }
                        User user = daoUser.checkuser(Username);
                        if (user!=null)
                        {
                            Toast.makeText(Login.this,"User Bị Trùng ",Toast.LENGTH_LONG).show();
                            return;
                        }
                        else
                        {
                            boolean result = daoUser.register(Username,Password);
                            if(result)
                            {
                                Toast.makeText(Login.this, "Đăng Kí Thành Công", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login.this, Home.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                });
            }
        });

    }
}