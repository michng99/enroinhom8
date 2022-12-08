package com.freesongs.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.freesongs.musikplayer8.Adapter.GetAllSongAdapter;
import com.freesongs.musikplayer8.DAO.DaoGetAllSongs;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class GetAddSongThemeAcitvity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Songs> list;
    com.freesongs.musikplayer8.Adapter.GetAllSongAdapter adapter;
    com.freesongs.musikplayer8.DAO.DaoGetAllSongs dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_add_song_theme_acitvity);


        dao = new DaoGetAllSongs(this);

        list = dao.getalladdBH();


        load_data(list);
    }
    public void load_data(ArrayList<Songs> list1) {
        recyclerView = findViewById(R.id.rev_addBH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        GetAllSongAdapter adapter = new GetAllSongAdapter(this, list1, 2);
        recyclerView.setAdapter(adapter);
    }
}