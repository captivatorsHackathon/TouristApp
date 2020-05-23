package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class capital extends AppCompatActivity {

    Button btn_lotus, btn_indiagate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);


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
        Intent intend= new Intent(this, gate.class);
        startActivity(intend);
    }

    public void openLotusActivity(){
        Intent intend= new Intent(this, lotus.class);
        startActivity(intend);

    }
}
