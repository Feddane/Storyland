package com.example.storyland;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StoriesActivity extends BaseActivity implements StoryAdapter.StoryClickListener{

    RecyclerView recyclerView;
    StoryAdapter storyAdapter;
    static List<Story> storyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);
        setData();
        prepareRecyclerView();

    }

    //On ajoute les histoires a la liste d'histoires  "List<Story> storyList"
    public void setData(){

        //story1
        List<Scene> story1Scenes = new ArrayList<>();
        story1Scenes.add(new Scene(R.drawable.story1, "Il était une fois..."));
        story1Scenes.add(new Scene(R.drawable.story2, "La fin."));
        Story story1 = new Story(R.drawable.story1, "The Easter Bunny School", "By Andrea Kaczmarek", story1Scenes);
        storyList.add(story1);

        //story2
        List<Scene> story2Scenes = new ArrayList<>();
        story2Scenes.add(new Scene(R.drawable.story2, "Once upon a time."));
        story2Scenes.add(new Scene(R.drawable.story3, "La fin magiiiiicccccccccccc"));
        Story story2 = new Story(R.drawable.story2, "The Bears in the kitchen", "By Andrea Kaczmarek", story2Scenes);
        storyList.add(story2);



    }

    public void prepareRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter(){
        storyAdapter = new StoryAdapter(storyList, this, this::selectedStory);
        recyclerView.setAdapter(storyAdapter);
    }

    @Override
    public void selectedStory(Story story) {
        Intent intent = new Intent(this, ScenesActivity.class);
        intent.putExtra("selected_story_index", storyList.indexOf(story));
        startActivity(intent);
    }

}