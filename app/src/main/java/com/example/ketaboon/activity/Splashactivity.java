package com.example.ketaboon.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ketaboon.R;

public  class  Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        boolean ISLOGIN = sharedPreferences.getBoolean("isLogin", false);

        if (ISLOGIN == true) {
            Handler jh = new Handler();

            jh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Splashactivity.this, MainActivity.class));
                    finish();
                }
            }, 2000);
        } else if (ISLOGIN == false) {
            Handler jh = new Handler();

            jh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Splashactivity.this, LoginActivity.class));
                    finish();
                }
            }, 6000);
        }


    }
}
