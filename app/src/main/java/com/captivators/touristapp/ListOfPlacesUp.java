package com.captivators.touristapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfPlacesUp extends AppCompatActivity {

    Button btn_taj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_places_up);

        btn_taj = findViewById(R.id.tajButton);

        btn_taj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTajActivity();
            }
        });


    }


    public void openTajActivity(){
        Intent intend= new Intent(this, TajMahalInfo.class);
        startActivity(intend);

    }
}
