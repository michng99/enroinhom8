package com.freesongs.musikplayer8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    RadioButton TiengViet;
    RadioButton TiengAnh;
    Switch Switch;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RadioGroup group;
    TextView hintLauguage , hintMode , t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
        group = findViewById(R.id.group);
        Switch = findViewById(R.id.switch1);
        //lưu chế độ khi thoát khỏi giao diện
        sharedPreferences = getSharedPreferences("Mode", Context.MODE_PRIVATE);
        // chế độ sáng sẽ default mode
        nightMode = sharedPreferences.getBoolean("night", false);

        if (nightMode) {
            Switch.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();
            }


        });




        // đổi ngôn ngữ
        t2 = findViewById(R.id.t2);
        hintMode = findViewById(R.id.hintMode);
        hintLauguage = findViewById(R.id.hintLauguage);
        TiengViet = findViewById(R.id.r_VI);
        TiengAnh = findViewById(R.id.r_En);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.r_VI:

                        String language = "VI";
                        //Set local
                        setlocale(language);

                        Toast.makeText(MainActivity.this, "Tiếng việt nè", Toast.LENGTH_SHORT).show();


                        break;
                    case R.id.r_En:
                        setlocale("EN");
                        Toast.makeText(MainActivity.this, "Tiếng anh nè", Toast.LENGTH_SHORT).show();
                        break;
                }
            }


        });

    }

    private void setlocale(String language) {
        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration,metrics);
        onConfigurationChanged(configuration);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        t2.setText(R.string.txtVan);
        hintLauguage.setText(R.string.txtlanguage);
        TiengViet.setText(R.string.VI);
        TiengAnh.setText(R.string.EN);
        hintMode.setText(R.string.Mode);
    }
}