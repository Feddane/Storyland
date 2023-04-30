package com.example.storyland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryAdapterVh> {

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
    public StoryAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.activity_story, parent, false);
        return new StoryAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapterVh holder, int position) {

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

//        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.animation_rv));

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class StoryAdapterVh extends RecyclerView.ViewHolder {

//        public View cardView;
        private TextView storyTitle;
        private ImageView storyImage;
        private TextView author;

        public StoryAdapterVh(@NonNull View itemView) {
            super(itemView);
            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyImage= itemView.findViewById(R.id.storyImg);
            author = itemView.findViewById(R.id.author);
        }
    }

}
