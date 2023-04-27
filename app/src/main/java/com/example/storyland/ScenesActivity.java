package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.List;

public class ScenesActivity extends BaseActivity {

    private ViewPager viewPager;
    private List<Scene> sceneList;
    private int selectedStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // récupération de l'indice de l'histoire sélectionnée
        selectedStoryIndex = getIntent().getIntExtra("selected_story_index", 0);

        // initialisation de la liste de scènes à partir de l'histoire sélectionnée
        Story selectedStory = StoriesActivity.storyList.get(selectedStoryIndex);
        sceneList = selectedStory.getScenes();

        // configuration du ViewPager
        viewPager = findViewById(R.id.viewpager);
        ScenePagerAdapter adapter = new ScenePagerAdapter(sceneList, this);
        viewPager.setAdapter(adapter);
    }
}