package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IndiaGateInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_gate_info);

        Button btn_india_gate = findViewById(R.id.discover_India_Gate);

        btn_india_gate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndiaGateInfo.this,IndiaGateMaps.class);
                startActivity(intent);
            }
        });
        Button btn_food = findViewById(R.id.food_India_Gate);
        Button btn_market = findViewById(R.id.market_India_Gate);



        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndiaGateInfo.this,DelhiFood.class);
                startActivity(intent);
            }
        });
        btn_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndiaGateInfo.this,DelhiMarket.class);
                startActivity(intent);
            }
        });
    }
}
