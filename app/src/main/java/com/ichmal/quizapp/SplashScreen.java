package com.ichmal.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent intentMain = new Intent(SplashScreen.this, HomeScreen.class);
                    startActivity(intentMain);
                    finish();
                }
            }
        };
        timer.start();
    }
}