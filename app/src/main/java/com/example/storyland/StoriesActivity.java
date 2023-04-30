package com.example.storyland;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    //Des qu'on clique sur le coeur(favourite list) situé sur ActionBar, on passe à FavouriteStoriesActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favourites) {
            Intent intent = new Intent(this, FavoriteStoriesActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //On ajoute les histoires a la liste d'histoires  "List<Story> storyList"
    public void setData(){

        //story1
        String[] scenes_story1 = getResources().getStringArray(R.array.scenes_story1);
        List<Scene> story1Scenes = new ArrayList<>();
        int story1AudioResourceId = R.raw.story1;
        story1Scenes.add(new Scene(R.drawable.scene1story1, scenes_story1[0]));
        story1Scenes.add(new Scene(R.drawable.scene2story1, scenes_story1[1]));
        story1Scenes.add(new Scene(R.drawable.scene3story1, scenes_story1[2]));
        story1Scenes.add(new Scene(R.drawable.scene4story1, scenes_story1[3]));
        story1Scenes.add(new Scene(R.drawable.scene5story1, scenes_story1[4]));
        story1Scenes.add(new Scene(R.drawable.scene6story1, scenes_story1[5]));
        story1Scenes.add(new Scene(R.drawable.scene7story1, scenes_story1[6]));
        story1Scenes.add(new Scene(R.drawable.scene8story1, scenes_story1[7]));
        story1Scenes.add(new Scene(R.drawable.scene9story1, scenes_story1[8]));
        story1Scenes.add(new Scene(R.drawable.scene10story1, scenes_story1[9]));
        story1Scenes.add(new Scene(R.drawable.scene11story1, scenes_story1[10]));
        story1Scenes.add(new Scene(R.drawable.scene12story1, scenes_story1[11]));
        story1Scenes.add(new Scene(R.drawable.scene13story1, scenes_story1[12]));
        story1Scenes.add(new Scene(R.drawable.scene14story1, scenes_story1[13]));
        story1Scenes.add(new Scene(R.drawable.scene15story1, scenes_story1[14]));
        story1Scenes.add(new Scene(R.drawable.scene16story1, scenes_story1[15]));
        story1Scenes.add(new Scene(R.drawable.scene17story1, scenes_story1[16]));
        story1Scenes.add(new Scene(R.drawable.scene18story1, scenes_story1[17]));
        story1Scenes.add(new Scene(R.drawable.scene19story1, scenes_story1[18]));
        Story story1 = new Story(1, R.drawable.story1, "The Easter Bunny School", "By Andrea Kaczmarek", story1Scenes, story1AudioResourceId);
        storyList.add(story1);

        //story2
        List<Scene> story2Scenes = new ArrayList<>();
        int story2AudioResourceId = R.raw.story2;
        story2Scenes.add(new Scene(R.drawable.story2, "Once upon a time."));
        story2Scenes.add(new Scene(R.drawable.story3, "La fin magiiiiicccccccccccc"));
        Story story2 = new Story(2, R.drawable.story2, "The Bears in the kitchen", "By Andrea Kaczmarek", story2Scenes, story2AudioResourceId);
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