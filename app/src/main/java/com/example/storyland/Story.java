package com.example.storyland;

import java.util.List;

//la classe qui definit une histoire (ses attributs, ses getters & setters)
public class Story {
    private int id;
    private int image;
    private String title;
    private String author;
    private List<Scene> scenes;
    private int audioResourceId;


    public Story(int id , int image, String title, String author,  List<Scene> scenes,  int audioResourceId) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.author = author;
        this.scenes = scenes;
        this.audioResourceId = audioResourceId;
    }

    public String getTitle() {
        return title;
    }


    public int getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
