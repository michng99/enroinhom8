package com.freesongs.musikplayer8;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream

public class MainActivity extends AppCompatActivity {

=======
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.freesongs.musikplayer8.adapter.BaiHatAdapter;
import com.freesongs.musikplayer8.model.BaiHat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    RecyclerView rycView;

    public static final String url = "https://172.16.88.153:8080/api/baihats";
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< Updated upstream
    }
}
=======

        bt1 = findViewById(R.id.bt1);




        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(i);
//                processData();
            }
        });

    }

//    private void processData()
//    {
//        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                GsonBuilder builder = new GsonBuilder();
//                Gson gson = builder.create();
//                BaiHat data[] = gson.fromJson(response, BaiHat[].class);
//
//                BaiHatAdapter adapter = new BaiHatAdapter(data);
//
//                rycView.setAdapter(adapter);
//
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//        );
//
//        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//        queue.add(request);


}



>>>>>>> Stashed changes
