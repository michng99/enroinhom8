package com.freesongs.testrestfulapiretrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "";

    private static Retrofit rtf;

    public static Retrofit getRTFInstance()
    {
        if (rtf == null)
        {
            rtf = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //convert json object to java object
                    .build();
        }
        return rtf;
    }
}
