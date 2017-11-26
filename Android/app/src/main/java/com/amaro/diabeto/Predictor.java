package com.amaro.diabeto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daasuu.cat.CountAnimationTextView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.gson.JsonSerializer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Predictor extends AppCompatActivity {

    int percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictor);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url;


        url = "http://27.250.14.42:5000/predict";
        final float[] percent = new float[1];
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.i("NIHAL",response);
                        JSONObject json=new JSONObject();
                        try {
                            json=new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            String value=json.getString("value");
                            percent[0] =Float.parseFloat(value);
                            setValue(percent[0]);
                            Log.i("NIHAL",value);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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

    public void moveToPremiumMenu(View view)
    {
        Intent intent=new Intent(this,PremiumMenu.class);
        startActivity(intent);
    }

    void setValue(float val)
    {
        val=val*100;
        percentage=Math.round(val);
        CountAnimationTextView mCountAnimationTextView = findViewById(R.id.percentageText);
        mCountAnimationTextView
                .setAnimationDuration(1500)
                .countAnimation(0,percentage);

        PieChart pieChart =  findViewById(R.id.pieChart);
        List<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(percentage,0));
        entries.add(new PieEntry((100-percentage),1));
        PieDataSet dataSet=new PieDataSet(entries,"");
        dataSet.setColors(Color.WHITE,Color.parseColor("#bdbdbd"));
        PieData pieData=new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setHoleRadius(90);
        pieChart.getDescription().setEnabled(false);
        pieData.setDrawValues(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.animateY(1500);

        CardView diabetesProgramCard=findViewById(R.id.diabetesProgramCard);
        if(percentage>50) {
            diabetesProgramCard.setVisibility(View.VISIBLE);
        }
    }
}
