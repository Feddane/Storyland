package com.example.storyland;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StoriesActivity extends BaseActivity implements StoryAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private StoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StorylandDBHelper mDatabaseHelper;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       context = getApplicationContext();
        mDatabaseHelper = new StorylandDBHelper(this);

        List<Story> stories = mDatabaseHelper.getAllStories();

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new StoryAdapter(stories, this);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

//        //Créer 10 histoires avec des scènes
//        Story story1 = new Story(1, "Histoire1",R.drawable.story1, Arrays.asList(
//                new Scene(1, R.drawable.story1, "Texte de la scène 1"),
//                new Scene(2, R.drawable.story2, "Texte de la scène 2"),
//                new Scene(3, R.drawable.story3, "Texte de la scène 3")
//        ));
//        Story story2 = new Story(2, "Histoire 2", R.drawable.story2, Arrays.asList(
//                new Scene(1, R.drawable.story4, "Texte de la scène 1"),
//                new Scene(2, R.drawable.story5, "Texte de la scène 2"),
//                new Scene(3, R.drawable.story6, "Texte de la scène 3")
//        ));
////        Story story3 = new Story("Histoire 3", R.drawable.story3, Arrays.asList(
////                new Scene("Scène 1", R.drawable.image1, "Texte de la scène 1"),
////                new Scene("Scène 2", R.drawable.image2, "Texte de la scène 2"),
////                new Scene("Scène 3", R.drawable.image3, "Texte de la scène 3")
////        ));
//
//
//        //Ajouter les histoires à la base de données
//                StorylandDBHelper dbHelper = new StorylandDBHelper(this);
//                dbHelper.addStory(story1);
//                dbHelper.addStory(story2);
//        //        dbHelper.addStory(story3);



// Create story 1
        StorylandDBHelper dbHelper1 = new StorylandDBHelper(this);
        List<Scene> scenes1 = Arrays.asList(
                new Scene(1, R.drawable.story1, "Text for scene 1"),
                new Scene(2, R.drawable.story2, "Text for scene 2"),
                new Scene(3, R.drawable.story3, "Text for scene 3")
        );
        Story story1 = new Story(1, "Story 1", R.drawable.story1, scenes1);

// Add story 1 to the database
        dbHelper1.addStory(story1);

// Create story 2
        StorylandDBHelper dbHelper2 = new StorylandDBHelper(this);
        List<Scene> scenes2 = Arrays.asList(
                new Scene(1, R.drawable.story4, "Text for scene 1"),
                new Scene(2, R.drawable.story5, "Text for scene 2"),
                new Scene(3, R.drawable.story6, "Text for scene 3")
        );
        Story story2 = new Story(2, "Story 2", R.drawable.story2, scenes2);

// Add story 2 to the database
        dbHelper2.addStory(story2);

        StorylandDBHelper dbHelper = new StorylandDBHelper(this);
        dbHelper = new StorylandDBHelper(context);
        stories = dbHelper.getAllStories();

        for (Story story : stories) {
            System.out.println(story.getTitle());
        }


    }

//    @Override
//    public void onItemClick(long position) {
//        Intent intent = new Intent(this, ScenesActivity.class);
//        intent.putExtra("story_id", mAdapter.getStoryId(position));
//        startActivity(intent);
//    }


    @Override
    public void onItemClick(Story story) {
        // Start ScenesActivity with the story ID
        Intent intent = new Intent(this, ScenesActivity.class);
        intent.putExtra("story_id", story.getId());
        startActivity(intent);
    }





}