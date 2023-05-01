package com.example.storyland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.storyland.StoriesActivity.storyList;

public class FavoriteStoriesActivity extends BaseActivity implements StoryAdapter.StoryClickListener {

    RecyclerView recyclerView;
    static StoryAdapter storyAdapter;
    static List<Story> favoriteStoriesList = new ArrayList<>();
    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String FAVORITES_SET_KEY = "favorite_stories_set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_stories);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);
        prepareRecyclerView();

    }

    private void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        storyAdapter = new StoryAdapter(favoriteStoriesList, this, this::selectedStory);
        recyclerView.setAdapter(storyAdapter);
    }

    @Override
    public void selectedStory(Story story) {
        // Do nothing
    }

    public static void addToFavorites(Context context, Story story) {
        if (favoriteStoriesList.contains(story)) {
            Toast.makeText(context, "Story already in favorites list", Toast.LENGTH_SHORT).show();
            return;
        }

        favoriteStoriesList.add(story);
        if (storyAdapter != null) {
            storyAdapter.notifyDataSetChanged();
        }
    }



    public static void removeFromFavorites(Story story) {
        favoriteStoriesList.remove(story);
        storyAdapter.notifyDataSetChanged();
    }

    public static boolean isFavorite(Context context, Story story) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favoritesSet = preferences.getStringSet(FAVORITES_SET_KEY, new HashSet<String>());

        String storyId = String.valueOf(story.getId());
        return favoritesSet.contains(storyId);
    }


}