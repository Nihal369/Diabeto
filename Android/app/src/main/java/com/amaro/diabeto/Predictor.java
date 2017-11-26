package com.amaro.diabeto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        int percentage=75;

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

    public void moveToPremiumMenu(View view)
    {
        Intent intent=new Intent(this,PremiumMenu.class);
        startActivity(intent);
    }
}
