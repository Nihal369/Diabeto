package com.amaro.diabeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Predictor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictor);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url;


        url = "http://www.httpbin.org/post";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String,String> stringIntegerMap=new HashMap<>();
                stringIntegerMap.put("pregnancies",String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("glucose",String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("bp",String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("skinThickness",String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("insulin",String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("BMI", String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("diabetesFunction", String.valueOf(LocalDB.getPregnancies()));
                stringIntegerMap.put("age", String.valueOf(LocalDB.getPregnancies()));


                return stringIntegerMap;
            }
        };

        queue.add(postRequest);
    }
}
