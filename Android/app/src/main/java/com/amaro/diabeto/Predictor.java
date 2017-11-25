package com.amaro.diabeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Predictor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predictor);

        Log.i("NIHAL", String.valueOf(LocalDB.getAge()));
        Log.i("NIHAL", String.valueOf(LocalDB.getBloodPressure()));
        Log.i("NIHAL", String.valueOf(LocalDB.getDiabeticPedigree()));
        Log.i("NIHAL", String.valueOf(LocalDB.getGender()));
        Log.i("NIHAL", String.valueOf(LocalDB.getGlucoseLevel()));
        Log.i("NIHAL", String.valueOf(LocalDB.getInsulinLevel()));
        Log.i("NIHAL", String.valueOf(LocalDB.getPregnancies()));
        Log.i("NIHAL", String.valueOf(LocalDB.getSkinThickness()));
    }
}
