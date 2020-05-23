package com.captivators.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {
    RelativeLayout relativeLayout ;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        thread.start();
    }


    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                textView = findViewById(R.id.tour);
                relativeLayout = findViewById(R.id.relative);

                Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                relativeLayout.startAnimation(aniFade);

                sleep(4000);

                Intent intent = new Intent(SplashActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}


