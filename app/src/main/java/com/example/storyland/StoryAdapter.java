package com.example.storyland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.storyland.StoriesActivity.storyList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    public List<Story> storyList = new ArrayList<>();
    public Context context;
    public StoryClickListener storyClickListener;

    //Quand l'utilisateur selectionne ou clique sur une histoire
    public interface  StoryClickListener{
        void selectedStory(Story story);
    }

    public StoryAdapter(List<Story> story, Context context, StoryClickListener storyClickListener){
        this.storyList = story;
        this.context = context;
        this.storyClickListener = storyClickListener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_story, parent, false);
        return new StoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {

        Story story = storyList.get(position);
        String storyTitle = story.getTitle();
        int storyImage = story.getImage();
        String author = story.getAuthor();

        holder.storyTitle.setText(storyTitle);
        holder.storyImage.setImageResource(storyImage);
        holder.author.setText(author);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyClickListener.selectedStory(story);
            }
        });

        // Check if the story is already in favorites
        boolean isFavorite = FavoriteStoriesActivity.isFavorite(holder.itemView.getContext(), story);

        // Show the appropriate button based on whether the story is in favorites or not
        if (isFavorite) {
            holder.addButton.setVisibility(View.GONE);
            holder.removeButton.setVisibility(View.VISIBLE);
        } else {
            holder.addButton.setVisibility(View.VISIBLE);
            holder.removeButton.setVisibility(View.GONE);
        }

        // Set OnClickListener for the "Add to Favorites" button
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add story to favorites
                Context context = holder.addButton.getContext();
                FavoriteStoriesActivity.addToFavorites(context, story);

                // Show the "Remove from Favorites" button and hide the "Add to Favorites" button
                holder.addButton.setVisibility(View.GONE);
                holder.removeButton.setVisibility(View.VISIBLE);

                // Show a Toast message
                Toast.makeText(holder.itemView.getContext(), "Story added to favorites", Toast.LENGTH_SHORT).show();
            }
        });

        // Set OnClickListener for the "Remove from Favorites" button
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove story from favorites
                Context context = holder.itemView.getContext();
                FavoriteStoriesActivity.removeFromFavorites(story);

                // Show the "Add to Favorites" button and hide the "Remove from Favorites" button
                holder.addButton.setVisibility(View.VISIBLE);
                holder.removeButton.setVisibility(View.GONE);

                // Show a Toast message
                Toast.makeText(holder.itemView.getContext(), "Story removed from favorites", Toast.LENGTH_SHORT).show();
            }
        });

        // Hide the buttons if the adapter is used in the FavouriteStoriesActivity
        if (context instanceof FavoriteStoriesActivity) {
            holder.addButton.setVisibility(View.GONE);
            holder.removeButton.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {

        private TextView storyTitle;
        private ImageView storyImage;
        private TextView author;
        private Button addButton;
        private Button removeButton;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyImage= itemView.findViewById(R.id.storyImg);
            author = itemView.findViewById(R.id.author);
            addButton = itemView.findViewById(R.id.add_buttton);
            removeButton = itemView.findViewById(R.id.remove_button);
        }
    }
}
