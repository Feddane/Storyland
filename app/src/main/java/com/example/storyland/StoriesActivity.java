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

    //On ajoute les histoires a la liste d'histoires  "List<Story> storyList, accompagnes des scenes + audio"
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

        //story4
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

        //story5
        String[] scenes_story5 = getResources().getStringArray(R.array.scenes_story5);
        List<Scene> story5Scenes = new ArrayList<>();
        int story5AudioResourceId = R.raw.story5;
        story5Scenes.add(new Scene(R.drawable.scene1story5, scenes_story5[0]));
        story5Scenes.add(new Scene(R.drawable.scene2story5, scenes_story5[1]));
        story5Scenes.add(new Scene(R.drawable.scene3story5, scenes_story5[2]));
        story5Scenes.add(new Scene(R.drawable.scene4story5, scenes_story5[3]));
        story5Scenes.add(new Scene(R.drawable.scene5story5, scenes_story5[4]));
        story5Scenes.add(new Scene(R.drawable.scene6story5, scenes_story5[5]));
        story5Scenes.add(new Scene(R.drawable.scene7story5, scenes_story5[6]));
        story5Scenes.add(new Scene(R.drawable.scene8story5, scenes_story5[7]));
        story5Scenes.add(new Scene(R.drawable.scene9story5, scenes_story5[8]));
        story5Scenes.add(new Scene(R.drawable.scene10story5, scenes_story5[9]));
        story5Scenes.add(new Scene(R.drawable.scene11story5, scenes_story5[10]));
        story5Scenes.add(new Scene(R.drawable.scene12story5, scenes_story5[11]));
        story5Scenes.add(new Scene(R.drawable.scene13story5, scenes_story5[12]));
        story5Scenes.add(new Scene(R.drawable.scene14story5, scenes_story5[13]));
        Story story5 = new Story(5, R.drawable.story5, "Frog’s Starry Wish", "By Sheesh Pal", story5Scenes, story5AudioResourceId);
        storyList.add(story5);


        //story6
        String[] scenes_story6 = getResources().getStringArray(R.array.scenes_story6);
        List<Scene> story6Scenes = new ArrayList<>();
        int story6AudioResourceId = R.raw.story6;
        story6Scenes.add(new Scene(R.drawable.scene1story6, scenes_story6[0]));
        story6Scenes.add(new Scene(R.drawable.scene2story6, scenes_story6[1]));
        story6Scenes.add(new Scene(R.drawable.scene3story6, scenes_story6[2]));
        story6Scenes.add(new Scene(R.drawable.scene4story6, scenes_story6[3]));
        story6Scenes.add(new Scene(R.drawable.scene5story6, scenes_story6[4]));
        story6Scenes.add(new Scene(R.drawable.scene6story6, scenes_story6[5]));
        story6Scenes.add(new Scene(R.drawable.scene7story6, scenes_story6[6]));
        story6Scenes.add(new Scene(R.drawable.scene8story6, scenes_story6[7]));
        story6Scenes.add(new Scene(R.drawable.scene9story6, scenes_story6[8]));
        story6Scenes.add(new Scene(R.drawable.scene10story6, scenes_story6[9]));
        story6Scenes.add(new Scene(R.drawable.scene11story6, scenes_story6[10]));
        Story story6 = new Story(6, R.drawable.story6, "I Love My Mom", "By Stephony Wail", story6Scenes, story6AudioResourceId);
        storyList.add(story6);


        //story7
        String[] scenes_story7 = getResources().getStringArray(R.array.scenes_story7);
        List<Scene> story7Scenes = new ArrayList<>();
        int story7AudioResourceId = R.raw.story7;
        story7Scenes.add(new Scene(R.drawable.scene1story7, scenes_story7[0]));
        story7Scenes.add(new Scene(R.drawable.scene2story7, scenes_story7[1]));
        story7Scenes.add(new Scene(R.drawable.scene3story7, scenes_story7[2]));
        story7Scenes.add(new Scene(R.drawable.scene4story7, scenes_story7[3]));
        story7Scenes.add(new Scene(R.drawable.scene5story7, scenes_story7[4]));
        story7Scenes.add(new Scene(R.drawable.scene6story7, scenes_story7[5]));
        story7Scenes.add(new Scene(R.drawable.scene7story7, scenes_story7[6]));
        story7Scenes.add(new Scene(R.drawable.scene8story7, scenes_story7[7]));
        story7Scenes.add(new Scene(R.drawable.scene9story7, scenes_story7[8]));
        story7Scenes.add(new Scene(R.drawable.scene10story7, scenes_story7[9]));
        story7Scenes.add(new Scene(R.drawable.scene11story7, scenes_story7[10]));
        story7Scenes.add(new Scene(R.drawable.scene12story7, scenes_story7[11]));
        story7Scenes.add(new Scene(R.drawable.scene13story7, scenes_story7[12]));
        story7Scenes.add(new Scene(R.drawable.scene14story7, scenes_story7[13]));
        story7Scenes.add(new Scene(R.drawable.scene15story7, scenes_story7[14]));
        story7Scenes.add(new Scene(R.drawable.scene16story7, scenes_story7[15]));
        story7Scenes.add(new Scene(R.drawable.scene17story7, scenes_story7[16]));
        story7Scenes.add(new Scene(R.drawable.scene18story7, scenes_story7[17]));
        story7Scenes.add(new Scene(R.drawable.scene19story7, scenes_story7[18]));
        story7Scenes.add(new Scene(R.drawable.scene20story7, scenes_story7[19]));
        Story story7 = new Story(7, R.drawable.story7, " My autumn senses", "By Stacie Eirich", story7Scenes, story7AudioResourceId);
        storyList.add(story7);

        //story8
        String[] scenes_story8 = getResources().getStringArray(R.array.scenes_story8);
        List<Scene> story8Scenes = new ArrayList<>();
        int story8AudioResourceId = R.raw.story8;
        story8Scenes.add(new Scene(R.drawable.scene1story8, scenes_story8[0]));
        story8Scenes.add(new Scene(R.drawable.scene2story8, scenes_story8[1]));
        story8Scenes.add(new Scene(R.drawable.scene3story8, scenes_story8[2]));
        story8Scenes.add(new Scene(R.drawable.scene4story8, scenes_story8[3]));
        story8Scenes.add(new Scene(R.drawable.scene5story8, scenes_story8[4]));
        story8Scenes.add(new Scene(R.drawable.scene6story8, scenes_story8[5]));
        story8Scenes.add(new Scene(R.drawable.scene7story8, scenes_story8[6]));
        story8Scenes.add(new Scene(R.drawable.scene8story8, scenes_story8[7]));
        story8Scenes.add(new Scene(R.drawable.scene9story8, scenes_story8[8]));
        story8Scenes.add(new Scene(R.drawable.scene10story8, scenes_story8[9]));
        story8Scenes.add(new Scene(R.drawable.scene11story8, scenes_story8[10]));
        story8Scenes.add(new Scene(R.drawable.scene12story8, scenes_story8[11]));
        story8Scenes.add(new Scene(R.drawable.scene13story8, scenes_story8[12]));
        story8Scenes.add(new Scene(R.drawable.scene14story8, scenes_story8[13]));
        story8Scenes.add(new Scene(R.drawable.scene15story8, scenes_story8[14]));
        story8Scenes.add(new Scene(R.drawable.scene16story8, scenes_story8[15]));
        story8Scenes.add(new Scene(R.drawable.scene17story8, scenes_story8[16]));
        story8Scenes.add(new Scene(R.drawable.scene18story8, scenes_story8[17]));
        story8Scenes.add(new Scene(R.drawable.scene19story8, scenes_story8[18]));
        story8Scenes.add(new Scene(R.drawable.scene20story8, scenes_story8[19]));

        Story story8 = new Story(8, R.drawable.story8, " Don’t Wake The Baby!", "By Huhynh Thi", story8Scenes, story8AudioResourceId);
        storyList.add(story8);

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