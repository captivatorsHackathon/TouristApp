package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LotusTempleInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotus_temple_info);

        Button btn_lotus_temple = findViewById(R.id.discover_lotus_temple);
        btn_lotus_temple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LotusTempleInfo.this,LotusTempleMaps.class);
                startActivity(intent);
            }
        });
        Button btn_food = findViewById(R.id.food_lotus_temple);
        Button btn_market = findViewById(R.id.market_lotus_temple);


        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LotusTempleInfo.this,DelhiFood.class);
                startActivity(intent);
            }
        });
        btn_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LotusTempleInfo.this,DelhiMarket.class);
                startActivity(intent);
            }
        });
    }
}
