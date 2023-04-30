package com.example.storyland;

import android.graphics.drawable.Drawable;

import java.util.List;

public class Story {
    private int id;
    private String title;
    private int image;
    private List<Scene> scenes;

    public Story(int id, String title, int image, List<Scene> scenes) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.scenes = scenes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
