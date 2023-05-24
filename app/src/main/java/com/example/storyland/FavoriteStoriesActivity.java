package com.example.storyland;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class FavoriteStoriesActivity extends BaseActivity implements StoryAdapter.StoryClickListener {

    RecyclerView recyclerView;
    static StoryAdapter storyAdapter;
    static List<Story> favoriteStoriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_stories);
        //Pour revenir a l'activite precedente
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);
        prepareRecyclerView();

        //Afficher le message "Your favorite stories list is empty" si la liste est vide
        TextView emptyFavoritesText = findViewById(R.id.emptyFavoritesText);
        if (favoriteStoriesList.isEmpty()) {
            emptyFavoritesText.setVisibility(View.VISIBLE);
        } else {
            emptyFavoritesText.setVisibility(View.GONE);
        }

    }

    private void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        storyAdapter = new StoryAdapter(favoriteStoriesList, this, this::selectedStory);
        recyclerView.setAdapter(storyAdapter);
    }

    @Override
    public void selectedStory(Story story) {
    }

    //Ajouter l'histoire dans favoris
    public static void addToFavorites(Context context, Story story) {
        if (favoriteStoriesList.contains(story)) {
            Toast.makeText(context, "Story already in favorites list", Toast.LENGTH_SHORT).show();
            return;
        }

        story.setFavorite(true);
        favoriteStoriesList.add(story);
        if (storyAdapter != null) {
            storyAdapter.notifyDataSetChanged();
        }
    }

    //Supprimer l'histoire des favoris
    public static void removeFromFavorites( Context context, Story story) {
        story.setFavorite(false);
        favoriteStoriesList.remove(story);
        if (storyAdapter != null) {
            storyAdapter.notifyDataSetChanged();
        }

    }


}