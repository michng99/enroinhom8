package com.freesongs.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.freesongs.musikplayer8.adapter.BaiHatAdapter;
import com.freesongs.musikplayer8.model.BaiHat;
import com.freesongs.musikplayer8.retrofit.ApiClient;
import com.freesongs.musikplayer8.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistActivity extends AppCompatActivity {

    BaiHatAdapter bhAdapter;
    RecyclerView rycView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        ApiInterface service = ApiClient.getRtfInstance().create(ApiInterface.class);

        Call<List<BaiHat>> call = service.getBaiHat();

        call.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Toast.makeText(PlaylistActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
















    private void loadDataList(List<BaiHat> dSBH1)
    {
        rycView = findViewById(R.id.rycView);
        bhAdapter = new BaiHatAdapter(dSBH1);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(PlaylistActivity.this);
        rycView.setLayoutManager(layout);
        rycView.setAdapter(bhAdapter);

    }




}