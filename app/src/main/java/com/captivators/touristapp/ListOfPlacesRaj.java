package com.captivators.touristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfPlacesRaj extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_places_raj);

        Button btn_hava = findViewById(R.id.havaButton);


        btn_hava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHavaActivity();
            }
        });



    }

    public void openHavaActivity(){
        Intent intend= new Intent(this, HavaMahalInfo.class);
        startActivity(intend);
    }



}
