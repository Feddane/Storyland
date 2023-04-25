package com.example.storyland;

public class Story {
    private int image;
    private String title;
    private String author;
//    private  List<Scene> scenes;


    public Story(int image, String title, String author) {
        this.image = image;
        this.title = title;
        this.author = author;
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
}
