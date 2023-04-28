package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ScenesActivity extends BaseActivity {

    private ViewPager mViewPager;
    private StorylandDBHelper mDatabaseHelper;
    private List<Scene> mScenes;

    public static final String EXTRA_STORY_ID = "com.example.storyland.STORY_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        //Pour revenir a l'activite
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get all the stories from the database
        mDatabaseHelper = new StorylandDBHelper(this);
        List<Story> stories = mDatabaseHelper.getAllStories();

        // Get the scenes for each story and add them to the list
        mScenes = new ArrayList<>();
        for (Story story : stories) {
            List<Scene> storyScenes = mDatabaseHelper.getScenesForStory(story.getId(), mDatabaseHelper.getReadableDatabase());
//            List<Scene> scenes = mDatabaseHelper.getScenesForStory(story.getId());
            mScenes.addAll(storyScenes);
        }

        // Set up the view pager with all the scenes
        mViewPager = findViewById(R.id.viewpager);
        ScenesPagerAdapter adapter = new ScenesPagerAdapter(mScenes);
        mViewPager.setAdapter(adapter);
    }
}