package com.captivators.touristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfPlacesDehli extends AppCompatActivity {

    Button btn_lotus, btn_indiagate,btn_taj,btn_hava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_places_dehli);


        btn_lotus= (Button)findViewById(R.id.lotusButton);
        btn_indiagate= (Button)findViewById(R.id.indiaButton);



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


    }

    public void openIndiaGateActivity(){
        Intent intend= new Intent(this, IndiaGateInfo.class);
        startActivity(intend);
    }


    public void openLotusActivity(){
        Intent intend= new Intent(this, LotusTempleInfo.class);
        startActivity(intend);

    }
}
