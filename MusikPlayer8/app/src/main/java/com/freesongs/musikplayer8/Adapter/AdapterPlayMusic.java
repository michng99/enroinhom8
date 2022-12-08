package com.freesongs.musikplayer8.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.freesongs.musikplayer8.Music.FragmentList;
import com.freesongs.musikplayer8.Music.FragmentPlay;


public class AdapterPlayMusic extends FragmentStateAdapter {
    public AdapterPlayMusic(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {

        switch (i) {
            case 0:
                return new FragmentPlay();
            case 1:
                return new FragmentList();
            default:
                return new FragmentPlay();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
