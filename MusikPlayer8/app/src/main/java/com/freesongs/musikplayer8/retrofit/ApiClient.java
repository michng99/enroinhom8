package com.freesongs.musikplayer8.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    private static Retrofit rtf;

    private static final String BASE_URL = "http://10.0.2.2:8080/api/";

    public static Retrofit getRtfInstance()
    {
        if (rtf == null)
        {
            rtf = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return rtf;
    }
}
