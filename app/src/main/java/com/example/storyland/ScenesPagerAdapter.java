package com.example.storyland;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ScenesPagerAdapter extends PagerAdapter {
    private List<Scene> scenes;

    public ScenesPagerAdapter(List<Scene> scenes) {
        this.scenes = scenes;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_scene, container, false);

        ImageView imageView = view.findViewById(R.id.sceneImg);
        TextView textView = view.findViewById(R.id.sceneText);

        Scene scene = scenes.get(position);
        imageView.setImageResource(scene.getImage());
        textView.setText(scene.getText());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return scenes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}


