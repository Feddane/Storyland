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
        String[] scenes_story2 = getResources().getStringArray(R.array.scenes_story2);
        List<Scene> story2Scenes = new ArrayList<>();
        int story2AudioResourceId = R.raw.story2;
        story2Scenes.add(new Scene(R.drawable.scene1story2, scenes_story2[0]));
        story2Scenes.add(new Scene(R.drawable.scene2story2, scenes_story2[1]));
        story2Scenes.add(new Scene(R.drawable.scene3story2, scenes_story2[2]));
        story2Scenes.add(new Scene(R.drawable.scene4story2, scenes_story2[3]));
        story2Scenes.add(new Scene(R.drawable.scene5story2, scenes_story2[4]));
        story2Scenes.add(new Scene(R.drawable.scene6story2, scenes_story2[5]));
        story2Scenes.add(new Scene(R.drawable.scene7story2, scenes_story2[6]));
        story2Scenes.add(new Scene(R.drawable.scene8story2, scenes_story2[7]));
        story2Scenes.add(new Scene(R.drawable.scene9story2, scenes_story2[8]));
        story2Scenes.add(new Scene(R.drawable.scene10story2, scenes_story2[9]));
        story2Scenes.add(new Scene(R.drawable.scene11story2, scenes_story2[10]));
        story2Scenes.add(new Scene(R.drawable.scene12story2, scenes_story2[11]));
        story2Scenes.add(new Scene(R.drawable.scene13story2, scenes_story2[12]));
        story2Scenes.add(new Scene(R.drawable.scene14story2, scenes_story2[13]));
        story2Scenes.add(new Scene(R.drawable.scene15story2, scenes_story2[14]));
        story2Scenes.add(new Scene(R.drawable.scene16story2, scenes_story2[15]));
        story2Scenes.add(new Scene(R.drawable.scene17story2, scenes_story2[16]));
        story2Scenes.add(new Scene(R.drawable.scene18story2, scenes_story2[17]));
        story2Scenes.add(new Scene(R.drawable.scene19story2, scenes_story2[18]));
        story2Scenes.add(new Scene(R.drawable.scene20story2, scenes_story2[19]));
        Story story2 = new Story(2, R.drawable.story2, "Golidocks and the Four Bears!", "By Andrea Kaczmarek", story2Scenes, story2AudioResourceId);
        storyList.add(story2);

        //story3
        String[] scenes_story3 = getResources().getStringArray(R.array.scenes_story3);
        List<Scene> story3Scenes = new ArrayList<>();
        int story3AudioResourceId = R.raw.story3;
        story3Scenes.add(new Scene(R.drawable.scene1story3, scenes_story3[0]));
        story3Scenes.add(new Scene(R.drawable.scene2story3, scenes_story3[1]));
        story3Scenes.add(new Scene(R.drawable.scene3story3, scenes_story3[2]));
        story3Scenes.add(new Scene(R.drawable.scene4story3, scenes_story3[3]));
        story3Scenes.add(new Scene(R.drawable.scene5story3, scenes_story3[4]));
        story3Scenes.add(new Scene(R.drawable.scene6story3, scenes_story3[5]));
        story3Scenes.add(new Scene(R.drawable.scene7story3, scenes_story3[6]));
        story3Scenes.add(new Scene(R.drawable.scene8story3, scenes_story3[7]));
        story3Scenes.add(new Scene(R.drawable.scene9story3, scenes_story3[8]));
        story3Scenes.add(new Scene(R.drawable.scene10story3, scenes_story3[9]));
        story3Scenes.add(new Scene(R.drawable.scene11story3, scenes_story3[10]));
        story3Scenes.add(new Scene(R.drawable.scene12story3, scenes_story3[11]));
        story3Scenes.add(new Scene(R.drawable.scene13story3, scenes_story3[12]));
        story3Scenes.add(new Scene(R.drawable.scene14story3, scenes_story3[13]));
        story3Scenes.add(new Scene(R.drawable.scene15story3, scenes_story3[14]));
        story3Scenes.add(new Scene(R.drawable.scene16story3, scenes_story3[15]));
        Story story3 = new Story(3, R.drawable.story3, "The Things That Really Matter", "By Refiloe Moahloli", story3Scenes, story3AudioResourceId);
        storyList.add(story3);

        //story3
        String[] scenes_story4 = getResources().getStringArray(R.array.scenes_story4);
        List<Scene> story4Scenes = new ArrayList<>();
        int story4AudioResourceId = R.raw.story4;
        story4Scenes.add(new Scene(R.drawable.scene1story4, scenes_story4[0]));
        story4Scenes.add(new Scene(R.drawable.scene2story4, scenes_story4[1]));
        story4Scenes.add(new Scene(R.drawable.scene3story4, scenes_story4[2]));
        story4Scenes.add(new Scene(R.drawable.scene4story4, scenes_story4[3]));
        story4Scenes.add(new Scene(R.drawable.scene5story4, scenes_story4[4]));
        story4Scenes.add(new Scene(R.drawable.scene6story4, scenes_story4[5]));
        story4Scenes.add(new Scene(R.drawable.scene7story4, scenes_story4[6]));
        story4Scenes.add(new Scene(R.drawable.scene8story4, scenes_story4[7]));
        story4Scenes.add(new Scene(R.drawable.scene9story4, scenes_story4[8]));
        story4Scenes.add(new Scene(R.drawable.scene10story4, scenes_story4[9]));
        story4Scenes.add(new Scene(R.drawable.scene11story4, scenes_story4[10]));
        story4Scenes.add(new Scene(R.drawable.scene12story4, scenes_story4[11]));
        story4Scenes.add(new Scene(R.drawable.scene13story4, scenes_story4[12]));
        story4Scenes.add(new Scene(R.drawable.scene14story4, scenes_story4[13]));
        Story story4 = new Story(4, R.drawable.story4, "Mama What’s For Lunch?", "By Sally Partdridge", story4Scenes, story4AudioResourceId);
        storyList.add(story4);

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

    @Override
    protected void onResume() {
        super.onResume();
        // Informer Adapter pour mettre à jour l'état du bouton favori
        storyAdapter.notifyDataSetChanged();
    }

}