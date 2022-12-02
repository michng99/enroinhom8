package com.freesongs.testrestfulapiretrofit.retrofit;

import com.freesongs.testrestfulapiretrofit.model.BaiHat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {




    @GET("baihats")
    Call<List<BaiHat>> getBaiHat();

}
