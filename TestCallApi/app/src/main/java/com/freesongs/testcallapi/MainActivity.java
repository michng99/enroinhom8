package com.freesongs.testcallapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.freesongs.testcallapi.adapter.BaiHatAdapter;
import com.freesongs.testcallapi.model.BaiHat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button bt;
    RecyclerView rycView;
    public static final String url = "http://10.0.2.2:8080/api/baihats";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rycView = findViewById(R.id.rycView);
        rycView.setLayoutManager(new LinearLayoutManager(this));
        bt = findViewById(R.id.bt1);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processData();
            }
        });

    }

    private void processData()
    {

        StringRequest sRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        BaiHat [] data = gson.fromJson(response, BaiHat[].class);
                        rycView.setAdapter(new BaiHatAdapter(data, getApplicationContext()));
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {


//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                return params;
//            }
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                String text = "key";
//                byte[] data = null;
//                try {
//                    data = text.getBytes("UTF-8");
//                } catch (UnsupportedEncodingException e1) {
//                    e1.printStackTrace();
//                }
//                String base64 = Base64.encodeToString(data, Base64.DEFAULT);
//                //  Authorization: Basic $auth
//                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("User-Agent","Bing Search Client for Android");
//                headers.put("x-auth-token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzZkMmE1MTE2YTQ1YTA0NTU0M2JmNmMiLCJuYW1lIjoidXNlcjAxIiwiaXNBZG1pbiI6dHJ1ZSwiaWF0IjoxNjY4MTA0OTI1LCJleHAiOjE2Njg3MDk3MjV9.PEIFfSSZqbvA6HOrNee8JzSe-rsZCYspDUd0NPgZCII");
//                //       headers.put("Content-Type", "application/json; charset=utf-8");
//                return headers;
//            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(sRequest);

    }




}