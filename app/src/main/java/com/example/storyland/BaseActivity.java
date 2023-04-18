package com.example.storyland;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textview1);
        TextView textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.myButton);

        // Get the screen width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        if (screenWidth > 600) {
            // Set margins for larger devices
            ConstraintLayout.LayoutParams params1 = (ConstraintLayout.LayoutParams) textView1.getLayoutParams();
            params1.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params1);

            ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) textView2.getLayoutParams();
            params2.setMargins(32, 32, 32, 32);
            textView2.setLayoutParams(params2);

            ConstraintLayout.LayoutParams params4 = (ConstraintLayout.LayoutParams) button.getLayoutParams();
            params4.setMargins(32, 32, 32, 32);
            button.setLayoutParams(params4);
        } else {
            // Set margins for smaller devices
            ConstraintLayout.LayoutParams params1 = (ConstraintLayout.LayoutParams) textView1.getLayoutParams();
            params1.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params1);

            ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) textView2.getLayoutParams();
            params2.setMargins(16, 16, 16, 16);
            textView2.setLayoutParams(params2);

            ConstraintLayout.LayoutParams params4 = (ConstraintLayout.LayoutParams) button.getLayoutParams();
            params4.setMargins(16, 16, 16, 16);
            button.setLayoutParams(params4);
        }
    }
}
