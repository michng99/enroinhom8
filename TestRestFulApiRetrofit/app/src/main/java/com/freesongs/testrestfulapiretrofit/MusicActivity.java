package com.freesongs.testrestfulapiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MusicActivity extends AppCompatActivity {

    ImageView ivMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ivMusic = findViewById(R.id.ivMusic);

        ivMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MusicActivity.this, PlaylistActivity.class);
                startActivity(i);
            }
        });


    }
}