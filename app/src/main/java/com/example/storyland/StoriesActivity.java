package com.example.storyland;

import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StoriesActivity extends BaseActivity implements StoryAdapter.StoryClickListener{

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

    //On ajoute les histoires a la liste d'histoires  "List<Story> storyList"
    public void setData(){
        storyList.add(new Story(R.drawable.story1, "The Easter Bunny School", "By Andrea Kaczmarek"));
        storyList.add(new Story(R.drawable.story2, "Golidocks and the Four Bears!", "By Jade Maitre"));
        storyList.add(new Story(R.drawable.story3, "The World’s Best Ice Cream", "By Andrea Kaczmarek"));
        storyList.add(new Story(R.drawable.story4, "The Princess Who Wasn’t", "By Templeton Moss"));
        storyList.add(new Story(R.drawable.story5, "My Friend, Funny", "By Jade Maitre"));
        storyList.add(new Story(R.drawable.story6, "The Neighbourhood Sofa", "By Yesim Serce"));
        storyList.add(new Story(R.drawable.story7, "Frog’s Starry Wish", "By Sheesh Pal"));
        storyList.add(new Story(R.drawable.story8, "Mama What’s For Lunch?", "By Sally Partdridge"));
        storyList.add(new Story(R.drawable.story9, "The Things That Really Matter", "By Refiloe Moahloli"));
        storyList.add(new Story(R.drawable.story10, "I Love My Mom ", "By Stephony Wail"));
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
        Toast.makeText(this, "COUCOUUU", Toast.LENGTH_SHORT).show();
    }
}