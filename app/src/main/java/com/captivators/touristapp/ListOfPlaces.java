package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListOfPlaces extends AppCompatActivity {

    Button btn_lotus, btn_indiagate,btn_taj,btn_hava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_places);


        btn_lotus= (Button)findViewById(R.id.lotusButton);
        btn_indiagate= (Button)findViewById(R.id.indiaButton);
        btn_taj= (Button)findViewById(R.id.tajButton);
        btn_hava= (Button)findViewById(R.id.havaButton);


        btn_indiagate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIndiaGateActivity();
            }
        });
        btn_lotus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLotusActivity();
            }
        });

        btn_taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTajActivity();
            }
        });
        btn_hava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHavaActivity();
            }
        });

    }

    public void openIndiaGateActivity(){
        Intent intend= new Intent(this, IndiaGateInfo.class);
        startActivity(intend);
    }

    public void openTajActivity(){
        Intent intend= new Intent(this, TajMahalInfo.class);
        startActivity(intend);
    }

    public void openHavaActivity(){
        Intent intend= new Intent(this, HavaMahalInfo.class);
        startActivity(intend);
    }

    public void openLotusActivity(){
        Intent intend= new Intent(this, LotusTempleInfo.class);
        startActivity(intend);

    }
}
