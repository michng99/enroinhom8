package com.freesongs.testrestfulapiretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.freesongs.testrestfulapiretrofit.adapter.BaiHatAdapter;
import com.freesongs.testrestfulapiretrofit.model.BaiHat;
import com.freesongs.testrestfulapiretrofit.retrofit.ApiClient;
import com.freesongs.testrestfulapiretrofit.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistActivity extends AppCompatActivity {

    private BaiHatAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //goi data tu api
        ApiInterface serviceInterface = ApiClient.getRTFInstance().create(ApiInterface.class);

        Call<List<BaiHat>> call = serviceInterface.getBaiHat();

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







    //ham chuc nang
    private void loadDataList(List<BaiHat> danhSachBaiHat)
    {
        recyclerView = findViewById(R.id.baiHatRecycleView);
        adapter = new BaiHatAdapter(danhSachBaiHat);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PlaylistActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}