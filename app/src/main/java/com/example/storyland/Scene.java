package com.example.storyland;

//la classe qui definit une scene (ses attributs, ses getters & setters)
public class Scene {
    private int imageScene;
    private String text;

    public Scene(int imageScene, String text) {
        this.imageScene = imageScene;
        this.text = text;
    }


    public int getImageScene() {
        return imageScene;
    }

    public void setImageScene(int imageScene) {
        this.imageScene = imageScene;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
