package com.freesongs.testcallapi.utils;

import com.android.volley.VolleyError;
import com.freesongs.testcallapi.model.BaiHat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public abstract class MakeRequest implements GetJsonObject
{
    @Override
    public JSONObject getJsonResponse(JSONObject j) throws JSONException
    {
//        {
//            "data": [
//            {
//                "_id": "6371a63afe6b540ea8b73114",
//                    "tenbaihat": "Như Những Phút Ban Đầu",
//                    "tacgia": "Lady Mây",
//                    "baihat": "nnpbd.mp3",
//                    "hinhanh": "nnpbdldm.jpg",
//                    "thoiluong": "6",
//                    "__v": 0
//            },
       JSONArray jsonArray = j.getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            String tenbaihat = jsonObject1.getString("tenBaiHat");
            String tacgia = jsonObject1.getString("tacGia");
            String baihat = jsonObject1.getString("baiHat");
            String hinhanh = jsonObject1.getString("hinhAnh");
            String thoiluong = jsonObject1.getString("thoiLuong");

            BaiHat bh = new BaiHat();
            bh.setTenbaihat(tenbaihat);
            bh.setTacgia(tacgia);
            bh.setBaihat(baihat);
            bh.setHinhanh(hinhanh);
            bh.setThoiluong(thoiluong);

            ArrayList<BaiHat> list = new ArrayList<>();
            list.add(bh);




        }
        return j;
    }

    @Override
    public JSONArray getJsonArray(JSONArray jsonArray) {
        return null;
    }

    @Override
    public VolleyError getError(VolleyError geterror) {
        return null;
    }
}
