package com.freesongs.musikplayer8.Music;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.freesongs.musikplayer8.Adapter.AdapterPlayMusic;
import com.freesongs.musikplayer8.R;

public class ChoiNhac extends AppCompatActivity {
    ViewPager2 viewpager22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_nhac);

        viewpager22 = findViewById(R.id.viewpager22);
        AdapterPlayMusic adapterPlayMusic = new AdapterPlayMusic(this);
        viewpager22.setAdapter(adapterPlayMusic);

    }
}