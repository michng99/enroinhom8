package com.freesongs.testcallapi.utils;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public interface GetJsonObject
{
    JSONObject getJsonResponse(JSONObject j) throws JSONException;

    JSONArray getJsonArray(JSONArray jsonArray);

    VolleyError getError(VolleyError getError);
}
