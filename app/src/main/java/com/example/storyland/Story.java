package com.example.storyland;

public class Story {
    private int image;
    private String title;
//    private  List<Scene> scenes;


    public Story(int image, String title) {
        this.image = image;
        this.title = title;
//        this.scenes = scenes;
    }

    public String getTitle() {
        return title;
    }

//    public List<Scene> getScenes() {
//        return scenes;
//    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
