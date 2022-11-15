package com.freesongs.musikplayer8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.freesongs.musikplayer8.model.BaiHat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<BaiHat> list;
    Button bt1;
    TextView tv;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://localhost:8080/api/baihats";

        pb = findViewById(R.id.idLoadingPB);
        bt1 = findViewById(R.id.bt1);
        tv = findViewById(R.id.lv1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsR = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                pb.setVisibility(View.GONE);
                                try {
                                    // now we get our response from API in json object format.
                                    // in below line we are extracting a string with its key
                                    // value from our json object.
                                    // similarly we are extracting all the strings from our json object.
                                    String tenbaihat = response.getString("Tên bài hát");
                                    String tacgia = response.getString("Tác giả");
                                    String baihat = response.getString("Bài hát");
                                    String hinhanh = response.getString("Hình ảnh");
                                    String thoiluong = response.getString("Thời lượng");

                                    String list = response.getString("Bài hát");

                                    // after extracting all the data we are
                                    // setting that data to all our views.
                                    tv.setText(list);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(jsR);
            }
        });
    }
}


