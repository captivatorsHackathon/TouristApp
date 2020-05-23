package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListOfStates extends AppCompatActivity {

    Button btn_up;
    Button btn_rajasthan;
    Button btn_delhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_states);


        btn_delhi= (Button)findViewById(R.id.DelhiButton);
        btn_rajasthan= (Button)findViewById(R.id.RajasthanButton);
        btn_up= (Button)findViewById(R.id.UPButton);

        btn_rajasthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRajActivity();
            }
        });
        btn_delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDelhiActivity();
            }
        });
        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUPActivity();
            }
        });


    }

    public  void openRajActivity(){
        Intent intend= new Intent(this, ListOfPlacesRaj.class);
        startActivity(intend);
    }

    public  void openDelhiActivity(){
        Intent intend= new Intent(this, ListOfPlacesDehli.class);
        startActivity(intend);
    }
    public  void openUPActivity(){
        Intent intend= new Intent(this, ListOfPlacesUp.class);
        startActivity(intend);
    }

}

