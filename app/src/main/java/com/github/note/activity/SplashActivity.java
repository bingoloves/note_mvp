package com.github.note.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bingo on 2020/11/6.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        },1200);
    }
}
