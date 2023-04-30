package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class ScenesActivity extends BaseActivity {

    private ViewPager viewPager;
    private List<Scene> sceneList;
    private int selectedStoryIndex;
    private TextView scenesCountTextView;

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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                int sceneCount = sceneList.size();
                scenesCountTextView.setText((position + 1) + "/" + sceneCount);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // initialisation du TextView pour afficher le nombre total de scènes
        scenesCountTextView = findViewById(R.id.textview_scenes_count);
        int sceneCount = sceneList.size();
        scenesCountTextView.setText("1/" + sceneCount);

        Button playButton = findViewById(R.id.playy);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int audioResourceId = selectedStory.getAudioResourceId();
                MediaPlayer mediaPlayer = MediaPlayer.create(ScenesActivity.this, audioResourceId);
                mediaPlayer.start();
            }
        });
    }
}