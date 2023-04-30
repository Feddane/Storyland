package com.example.storyland;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
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

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    private List<Story> mStories;
    private OnItemClickListener mListener;
    private Context mContext;

    public StoryAdapter(List<Story> stories, Context context) {
        mStories = stories;
        mContext = context;
    }

    public interface OnItemClickListener {
        void onItemClick(Story story);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_story, parent, false);
        StoryViewHolder viewHolder = new StoryViewHolder(v, mListener);
        v.setTag(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story currentStory = mStories.get(position);

        holder.mTitleTextView.setText(currentStory.getTitle());
        holder.mImageView.setImageResource(currentStory.getImage());
    }

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;
        public ImageView mImageView;

        public StoryViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTitleTextView = itemView.findViewById(R.id.storyTitle);
            mImageView = itemView.findViewById(R.id.storyImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Story clickedStory = mStories.get(position);
                            listener.onItemClick(clickedStory);
                        }
                    }
                }
            });
        }
    }
}
