package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TajMahalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taj_mahal_info);

        Button btn_taj_maps = findViewById(R.id.discover_taj);

        btn_taj_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TajMahalInfo.this,TajMahalMaps.class);
                startActivity(intent);
            }
        });
        Button btn_food = findViewById(R.id.food_taj);
        Button btn_market = findViewById(R.id.market_taj);


        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TajMahalInfo.this,UpFood.class);
                startActivity(intent);
            }
        });
        btn_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TajMahalInfo.this,UpMarket.class);
                startActivity(intent);
            }
        });
    }
}
