package com.freesongs.musikplayer8.Music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.freesongs.musikplayer8.Adapter.AdapterListBXH;
import com.freesongs.musikplayer8.Adapter.AdapterPlayMusic;
import com.freesongs.musikplayer8.R;

public class ChoiNhac extends AppCompatActivity {
    ViewPager2 viewpager22 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_nhac);
        viewpager22 = findViewById(R.id.viewpager22);
        AdapterPlayMusic adapterPlayMusic = new AdapterPlayMusic(this);
        viewpager22.setAdapter(adapterPlayMusic);
    }

}