package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintLayout = findViewById(R.id.constraintLayout);

        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        // Adjust margins for textView1
        ConstraintSet constraintSet1 = new ConstraintSet();
        constraintSet1.clone(mConstraintLayout);
        if (dpWidth > 600) {
            constraintSet1.setMargin(R.id.textview1, ConstraintSet.START, 64);
            constraintSet1.setMargin(R.id.textview1, ConstraintSet.END, 64);
        } else {
            constraintSet1.setMargin(R.id.textview1, ConstraintSet.START, 32);
            constraintSet1.setMargin(R.id.textview1, ConstraintSet.END, 32);
        }
        constraintSet1.applyTo(mConstraintLayout);

// Adjust margins for textView2
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(mConstraintLayout);
        if (dpWidth > 600) {
            constraintSet2.setMargin(R.id.textView2, ConstraintSet.START, 64);
            constraintSet2.setMargin(R.id.textView2, ConstraintSet.END, 64);
        } else {
            constraintSet2.setMargin(R.id.textView2, ConstraintSet.START, 32);
            constraintSet2.setMargin(R.id.textView2, ConstraintSet.END, 32);
        }
        constraintSet2.applyTo(mConstraintLayout);

        // Adjust margins for myButton
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(mConstraintLayout);
        if (dpWidth > 600) {
            constraintSet3.setMargin(R.id.myButton, ConstraintSet.START, 64);
            constraintSet3.setMargin(R.id.myButton, ConstraintSet.END, 64);
        } else {
            constraintSet3.setMargin(R.id.myButton, ConstraintSet.START, 32);
            constraintSet3.setMargin(R.id.myButton, ConstraintSet.END, 32);
        }
        constraintSet3.applyTo(mConstraintLayout);
        }

    }