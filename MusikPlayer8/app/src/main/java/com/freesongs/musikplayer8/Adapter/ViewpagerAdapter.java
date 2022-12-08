package com.freesongs.musikplayer8.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.freesongs.musikplayer8.Music.FragmentMusic;
import com.freesongs.musikplayer8.News.FragmentNews;
import com.freesongs.musikplayer8.Playlist.FragmentPlaylist;
import com.freesongs.musikplayer8.Setting.FragmentSetting;

public class ViewpagerAdapter extends FragmentStateAdapter {
    public ViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {

        switch (i) {
            case 0:
                return new FragmentMusic();
            case 1:
                return new FragmentPlaylist();
            case 2:
                return new FragmentNews();
            case 3:
                return new FragmentSetting();
            default:
                return new FragmentMusic();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
