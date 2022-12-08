package com.freesongs.musikplayer8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.freesongs.musikplayer8.Adapter.ViewpagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    ViewPager2 viewpager2;
    BottomNavigationView bottomnavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewpager2 = findViewById(R.id.viewpager2);
        bottomnavigation = findViewById(R.id.bottomnavigation);
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(this);
        viewpager2.setAdapter(viewpagerAdapter);

        viewpager2.setPageTransformer(new DepthPageTransformer());

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int a) {
                super.onPageSelected(a);

                switch (a){
                    case 0:
                        bottomnavigation.getMenu().findItem(R.id.music).setChecked(true);
                        break;
                    case 1:
                        bottomnavigation.getMenu().findItem(R.id.playlist).setChecked(true);
                        break;
                    case 2:
                        bottomnavigation.getMenu().findItem(R.id.news).setChecked(true);
                        break;
                    case 3:
                        bottomnavigation.getMenu().findItem(R.id.user).setChecked(true);
                        break;
                }

            }
        });

        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.music:
                        viewpager2.setCurrentItem(0);
                        break;
                    case R.id.playlist:
                        viewpager2.setCurrentItem(1);
                        break;
                    case R.id.news:
                        viewpager2.setCurrentItem(2);
                        break;
                    case R.id.user:
                        viewpager2.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
    }
}