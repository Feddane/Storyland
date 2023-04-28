package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ScenesActivity extends BaseActivity {

    private ViewPager mViewPager;
    private StorylandDBHelper mDatabaseHelper;
    private List<Scene> mScenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        //Pour revenir a l'activite
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get the story ID passed from the previous activity
        Intent intent = getIntent();
        int storyId = intent.getIntExtra("story_id", -1);

        // Check if storyId is valid
        if (storyId != -1) {
            // Set up the view pager with the scenes
            mDatabaseHelper = new StorylandDBHelper(this);
            mScenes = mDatabaseHelper.getScenesForStory((long) storyId, mDatabaseHelper.getReadableDatabase());
            mViewPager = findViewById(R.id.viewpager);
            ScenesPagerAdapter adapter = new ScenesPagerAdapter(mScenes);
            mViewPager.setAdapter(adapter);
        } else {
            // Handle the case where storyId is invalid
            Toast.makeText(this, "Error: Invalid story ID", Toast.LENGTH_SHORT).show();
        }
    }
}