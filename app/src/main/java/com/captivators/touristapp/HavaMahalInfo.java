package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HavaMahalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hava_mahal_info);
        Button btn_hava_mahal = findViewById(R.id.discover_Hava_Mahal);
        Button btn_food = findViewById(R.id.food_Hava_Mahal);
        Button btn_market = findViewById(R.id.market_Hava_Mahal);



        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HavaMahalInfo.this,PinkCityFood.class);
                startActivity(intent);
            }
        });
        btn_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HavaMahalInfo.this,PinkCityMarket.class);
                startActivity(intent);
            }
        });
        btn_hava_mahal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HavaMahalInfo.this,HavaMahalMaps.class);
                startActivity(intent);
            }
        });
    }
}
