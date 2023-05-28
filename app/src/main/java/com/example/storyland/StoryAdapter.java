package com.example.storyland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


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

        // Vérifie si l'histoire est déjà dans les favoris
        boolean isFavorite = story.isFavorite();

        if(isFavorite) {
            holder.addButton.setVisibility(View.GONE);
            holder.removeButton.setVisibility(View.VISIBLE);
        } else {
            holder.addButton.setVisibility(View.VISIBLE);
            holder.removeButton.setVisibility(View.GONE);
        }

        // Définir OnClickListener pour le bouton "Ajouter aux favoris"
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajouter l'histoire aux favoris
                Context context = holder.addButton.getContext();
                FavoriteStoriesActivity.addToFavorites(context, story);

                // Mettre a jour "isFavorite" pour l'histoire
                story.setFavorite(true);

                // Afficher le bouton "Supprimer des favoris" et masquer le bouton "Ajouter aux favoris"
                holder.addButton.setVisibility(View.GONE);
                holder.removeButton.setVisibility(View.VISIBLE);

                // Afficher un message Toast pour informer l'utilisateur que l'histoire a bien ete ajouter
                Toast.makeText(holder.itemView.getContext(), "Story added to favorites", Toast.LENGTH_SHORT).show();
            }
        });

        // Définir OnClickListener pour le bouton "Supprimer des favoris"
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Supprimer l'histoire des favoris
                FavoriteStoriesActivity.removeFromFavorites(context, story);

                // Mettre à jour le drapeau isFavorite pour l'histoire
                story.setFavorite(false);

                // Afficher le bouton "Ajouter aux favoris" et masquer le bouton "Supprimer des favoris"
                holder.addButton.setVisibility(View.VISIBLE);
                holder.removeButton.setVisibility(View.GONE);

                // Afficher un message Toast pour informer l'utilisateur que l'histoire a bien ete supprimer
                Toast.makeText(holder.itemView.getContext(), "Story removed from favorites", Toast.LENGTH_SHORT).show();
            }
        });

        // Cacher les boutons si Adapter est utilisé dans la FavoriteStoriesActivity = Supprimer les boutons dans FavoriteStoriesActivity
        if (context instanceof FavoriteStoriesActivity) {
            holder.addButton.setVisibility(View.GONE);
            holder.removeButton.setVisibility(View.VISIBLE);
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
