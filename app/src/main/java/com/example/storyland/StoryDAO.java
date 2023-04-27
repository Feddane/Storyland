package com.example.storyland;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class StoryDAO {
    private SQLiteDatabase database;
    private StorylandDBHelper dbHelper;
    Context context;

    public StoryDAO(Context context) {
        dbHelper = new StorylandDBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public List<Story> getAllStories() {
        List<Story> stories = new ArrayList<>();

        Cursor cursor = database.query(StorylandDBHelper.TABLE_HISTOIRES, null, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Story story = new Story();
            story.setId(cursor.getInt(cursor.getColumnIndexOrThrow(StorylandDBHelper.COLUMN_HISTOIRE_ID)));
            story.setTitre(cursor.getString(cursor.getColumnIndexOrThrow(StorylandDBHelper.COLUMN_HISTOIRE_TITRE)));
            story.setImage(cursor.getBlob(cursor.getColumnIndexOrThrow(StorylandDBHelper.COLUMN_HISTOIRE_IMAGE)));
//            story.setScenes(getScenesByStoryId(story.getId(), context));
            stories.add(story);
            cursor.moveToNext();
        }
        cursor.close();

        return stories;
    }

//    public List<Scene> getScenesByStoryId(int histoireId, Context context) {
//        List<Scene> scenes = new ArrayList<>();
//
//        String selection = StorylandDBHelper.COLUMN_SCENE_HISTOIRE_ID + " = ?";
//        String[] selectionArgs = {String.valueOf(histoireId)};
//
//        Cursor cursor = database.query(StorylandDBHelper.TABLE_SCENES, null, selection, selectionArgs, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Scene scene = new Scene();
//            scene.setId(cursor.getInt(cursor.getColumnIndex(StorylandDBHelper.COLUMN_SCENE_ID)));
//            String imageName = cursor.getString(cursor.getColumnIndex(StorylandDBHelper.COLUMN_SCENE_IMAGE));
//            int resourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
//            Drawable drawable = context.getResources().getDrawable(resourceId);
//            scene.setImage(drawable);
//            scene.setTexte(cursor.getString(cursor.getColumnIndex(StorylandDBHelper.COLUMN_SCENE_TEXTE)));
//            scenes.add(scene);
//            cursor.moveToNext();
//        }
//        cursor.close();
//
//        return scenes;
//    }
}
