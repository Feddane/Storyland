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

    private ImageView bt_play, bt_pause, bt_ff, bt_rew;
    private MediaPlayer mediaPlayer;
    private SeekBar seek_bar;
    private Handler handler;
    private TextView player_position, player_duration;

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

        bt_play = findViewById(R.id.bt_play);
        bt_pause = findViewById(R.id.bt_pause);
        bt_ff = findViewById(R.id.bt_ff);
        bt_rew = findViewById(R.id.bt_rew);
        mediaPlayer = MediaPlayer.create(this, selectedStory.getAudioResourceId());
        seek_bar = findViewById(R.id.seek_bar);
        handler = new Handler();
        player_position = findViewById(R.id.player_position);
        player_duration = findViewById(R.id.player_duration);


        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                bt_play.setVisibility(View.GONE);
                bt_pause.setVisibility(View.VISIBLE);

                int duration = mediaPlayer.getDuration();
                seek_bar.setMax(duration);

                handler.postDelayed(seekBarRunnable, 0);
            }
        });


        bt_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                bt_pause.setVisibility(View.GONE);
                bt_play.setVisibility(View.VISIBLE);
            }
        });

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }

        });

        bt_rew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition - 10000 > 0) {
                    mediaPlayer.seekTo(currentPosition - 10000);
                } else {
                    mediaPlayer.seekTo(0);
                }
            }
        });

        bt_ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                if (currentPosition + 10000 < duration) {
                    mediaPlayer.seekTo(currentPosition + 10000);
                } else {
                    mediaPlayer.seekTo(duration);
                }
            }
        });
    }

    public void seekUpdation() {
        seek_bar.setProgress(mediaPlayer.getCurrentPosition());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                seekUpdation();
            }
        }, 100);
    }

    private Runnable seekBarRunnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = mediaPlayer.getCurrentPosition();
            seek_bar.setProgress(currentPosition);

            // update the time display
            String currentPositionStr = createTimeLabel(currentPosition);
            player_position.setText(currentPositionStr);

            handler.postDelayed(this, 1000);
        }
    };

    private String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

}


