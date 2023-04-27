package com.example.storyland;

import android.graphics.drawable.Drawable;

public class Scene {
    private int id;
    private Drawable image;
    private String texte;

    public Scene() {}

    public Scene(int id, Drawable image, String texte) {
        this.id = id;
        this.image = image;
        this.texte = texte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
