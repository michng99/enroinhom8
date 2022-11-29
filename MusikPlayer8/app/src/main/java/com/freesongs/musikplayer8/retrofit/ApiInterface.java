package com.freesongs.musikplayer8.retrofit;

import com.freesongs.musikplayer8.model.BaiHat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{

    @GET("baihats")
    Call<List<BaiHat>> getBaiHat();

}
