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
        Button btn_hava_mahal = findViewById(R.id.discover_hava_mahal);

        btn_hava_mahal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HavaMahalInfo.this,HavaMahalMaps.class);
                startActivity(intent);
            }
        });
    }
}
