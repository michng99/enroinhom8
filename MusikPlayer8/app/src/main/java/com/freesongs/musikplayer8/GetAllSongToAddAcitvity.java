package com.freesongs.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.freesongs.musikplayer8.Adapter.GetAllSongAdapter;
import com.freesongs.musikplayer8.DAO.DaoGetAllSongs;
import com.freesongs.musikplayer8.model.Songs;

import java.util.ArrayList;

public class GetAllSongToAddAcitvity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Songs> list;
    GetAllSongAdapter adapter;
    DaoGetAllSongs dao;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_song_to_add_acitvity);


        dao  = new DaoGetAllSongs(this);

        list = dao.getall();
        btn = findViewById(R.id.btnChuyen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetAllSongToAddAcitvity.this, GetAddSongThemeAcitvity.class));
            }
        });


        load_data(list);
    }

    public void load_data(ArrayList<Songs> list1) {
        recyclerView = findViewById(R.id.rcv_getall);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        GetAllSongAdapter adapter = new GetAllSongAdapter(this, list1, 1);
        recyclerView.setAdapter(adapter);
    }
}