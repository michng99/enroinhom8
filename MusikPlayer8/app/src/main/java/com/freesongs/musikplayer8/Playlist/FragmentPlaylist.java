package com.freesongs.musikplayer8.Playlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.freesongs.musikplayer8.R;

public class FragmentPlaylist extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_playlist , container , false );

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);






        return view;
    }
}
