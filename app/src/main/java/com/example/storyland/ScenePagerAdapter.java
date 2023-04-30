package com.example.storyland;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ScenePagerAdapter extends PagerAdapter {
    private List<Scene> sceneList;
    private LayoutInflater layoutInflater;
    private Context context;

    public ScenePagerAdapter(List<Scene> sceneList, Context context) {
        this.sceneList = sceneList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sceneList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.activity_scene, container, false);

        ImageView sceneImage = view.findViewById(R.id.sceneImg);
        TextView sceneText = view.findViewById(R.id.sceneText);

        Scene scene = sceneList.get(position);

        sceneImage.setImageResource(scene.getImageScene());
        sceneText.setText(scene.getText());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
