package com.example.storyland;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StoriesActivity extends BaseActivity {

    RecyclerView recyclerView;
    StoryAdapter storyAdapter;
    List<Story> storyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        recyclerView = findViewById(R.id.recyclerview);
        setData();
        prepareRecyclerView();

    }

    public void setData(){
        storyList.add(new Story(R.drawable.easterbunny, "The Easter Bunny School"));
        storyList.add(new Story(R.drawable.lilypad, "Where's My Lily Pad?"));
    }

    public void prepareRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter(){
        storyAdapter = new StoryAdapter(storyList, this);
        recyclerView.setAdapter(storyAdapter);
    }

}