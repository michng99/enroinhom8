package com.freesongs.musikplayer8.Playlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freesongs.musikplayer8.Adapter.PlaylistAdapter;
import com.freesongs.musikplayer8.GetAllSongToAddAcitvity;
import com.freesongs.musikplayer8.Helper.SpanSizeLookupPlaylist;
import com.freesongs.musikplayer8.R;
import com.freesongs.musikplayer8.model.Playlists;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class FragmentPlaylist extends Fragment {

    RecyclerView ryc;
    ArrayList<Playlists> playlists;
    PlaylistAdapter adapter;
    GridLayoutManager layoutManager;
    Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_playlist, container,false);

        ryc = view.findViewById(R.id.rycView_playlist);
        playlists = new ArrayList<>();
        dataInsertStatic();




        layoutManager = new GridLayoutManager(this.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new SpanSizeLookupPlaylist(5, 1, 2));
        ryc.setLayoutManager(layoutManager);
        adapter = new PlaylistAdapter(getContext(),playlists);
        ryc.setAdapter(adapter);

        btnAdd = view.findViewById(R.id.btnAddNewSong);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), GetAllSongToAddAcitvity.class);
                startActivity(i);
            }
        });
        return view;



    }





    private void dataInsertStatic()
    {
        playlists.add(new Playlists("https://i.ytimg.com/vi/6KCff8T5tR0/sddefault.jpg"));
        playlists.add(new Playlists("https://photo-resize-zmp3.zmdcdn.me/w240_r1x1_jpeg/covers/5/6/565529288dd71c8a1e583629f6a7227d_1390906654.jpg"));
        playlists.add(new Playlists("https://t4.ftcdn.net/jpg/04/10/41/03/360_F_410410310_Ywr5cu2CrpMZ4L54CSdTLhQdDCGYv7NK.jpg"));
    }
}
