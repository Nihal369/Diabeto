package com.amaro.diabeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PremiumMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_menu);
    }

    public void launchWebView(View view)
    {
        Intent intent=new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }
}
