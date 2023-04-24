package com.example.storyland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryAdapterVh> {

    public List<Story> storyList = new ArrayList<>();
    public Context context;


    public StoryAdapter(List<Story> story, Context context){
        this.storyList = story;
        this.context = context;
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

        holder.storyTitle.setText(storyTitle);
        holder.storyImage.setImageResource(storyImage);

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class StoryAdapterVh extends RecyclerView.ViewHolder {

        private TextView storyTitle;
        private ImageView storyImage;

        public StoryAdapterVh(@NonNull View itemView) {
            super(itemView);
            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyImage= itemView.findViewById(R.id.storyImg);
        }
    }

}
