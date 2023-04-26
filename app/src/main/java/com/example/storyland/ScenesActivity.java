package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ScenesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}