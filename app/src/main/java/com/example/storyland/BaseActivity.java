package com.example.storyland;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textview1);
        TextView textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.myButton);

        // Find the views in the other layout files
        View otherView1 = getLayoutInflater().inflate(R.layout.activity_story, null);
        View otherView2 = getLayoutInflater().inflate(R.layout.activity_stories, null);

        // Add the other views to the main layout
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        constraintLayout.addView(otherView1);
        constraintLayout.addView(otherView2);

        TextView textView3 = otherView1.findViewById(R.id.storyTitle);
        TextView textView4 = otherView1.findViewById(R.id.author);
        ImageView storyImage = otherView1.findViewById(R.id.storyImg);
        RecyclerView recyclerView = otherView2.findViewById(R.id.recyclerview);


        // Get the screen width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        if (screenWidth > 600) {
            // Set margins for larger devices
            ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) textView1.getLayoutParams();
            params1.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params1);

            ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
            params2.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params2);

            ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            params3.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params3);

            ViewGroup.MarginLayoutParams params4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
            params4.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params4);

            ViewGroup.MarginLayoutParams params5 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
            params5.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params5);

            ViewGroup.MarginLayoutParams params6 = (ViewGroup.MarginLayoutParams) storyImage.getLayoutParams();
            params6.setMargins(32, 32, 32, 32);
            textView1.setLayoutParams(params6);

            ViewGroup.MarginLayoutParams params7 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
            params7.setMargins(32, 32, 32, 32);
            textView4.setLayoutParams(params7);



        } else {
            // Set margins for smaller devices
            ViewGroup.MarginLayoutParams params1 = (ViewGroup.MarginLayoutParams) textView1.getLayoutParams();
            params1.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params1);

            ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
            params2.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params2);

            ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
            params3.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params3);

            ViewGroup.MarginLayoutParams params4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
            params4.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params4);

            ViewGroup.MarginLayoutParams params5 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
            params5.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params5);

            ViewGroup.MarginLayoutParams params6 = (ViewGroup.MarginLayoutParams) storyImage.getLayoutParams();
            params6.setMargins(16, 16, 16, 16);
            textView1.setLayoutParams(params6);

            ViewGroup.MarginLayoutParams params7 = (ViewGroup.MarginLayoutParams) recyclerView.getLayoutParams();
            params7.setMargins(16, 16, 16, 16);
            textView4.setLayoutParams(params7);


        }
    }
}
