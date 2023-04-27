package com.example.storyland;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StorylandDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "stories.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_STORIES = "stories";
    private static final String COLUMN_STORY_ID = "id";
    private static final String COLUMN_STORY_TITLE = "title";
    private static final String COLUMN_STORY_IMAGE = "image";

    private static final String TABLE_SCENES = "scenes";
    private static final String COLUMN_SCENE_ID = "id";
    private static final String COLUMN_SCENE_TITLE = "title";
    private static final String COLUMN_SCENE_IMAGE = "image";
    private static final String COLUMN_SCENE_TEXT = "text";
    private static final String COLUMN_SCENE_STORY_ID = "story_id";

    private static final String CREATE_TABLE_STORIES = "CREATE TABLE " + TABLE_STORIES + " ("
            + COLUMN_STORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STORY_TITLE + " TEXT NOT NULL, "
            + COLUMN_STORY_IMAGE + " INTEGER NOT NULL"
            + ");";

    private static final String CREATE_TABLE_SCENES = "CREATE TABLE " + TABLE_SCENES + " ("
            + COLUMN_SCENE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SCENE_TITLE + " TEXT NOT NULL, "
            + COLUMN_SCENE_IMAGE + " INTEGER NOT NULL, "
            + COLUMN_SCENE_TEXT + " TEXT NOT NULL, "
            + COLUMN_SCENE_STORY_ID + " INTEGER NOT NULL, "
            + "FOREIGN KEY (" + COLUMN_SCENE_STORY_ID + ") REFERENCES " + TABLE_STORIES + " (" + COLUMN_STORY_ID + ")"
            + ");";
    public StorylandDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STORIES);
        db.execSQL(CREATE_TABLE_SCENES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCENES);
        onCreate(db);
    }

    public long addStory(Story story) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_STORY_TITLE, story.getTitle());
        values.put(COLUMN_STORY_IMAGE, story.getImage());

        long id = db.insert(TABLE_STORIES, null, values);

        for (Scene scene : story.getScenes()) {
            addScene(scene, id, db);
        }

        db.close();

        return id;
    }

    private long addScene(Scene scene, long storyId, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCENE_IMAGE, scene.getImage());
        values.put(COLUMN_SCENE_TEXT, scene.getText());
        values.put(COLUMN_SCENE_STORY_ID, storyId);

        return db.insert(TABLE_SCENES, null, values);
    }

    public List<Story> getAllStories() {
        List<Story> stories = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_STORIES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STORY_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STORY_TITLE));
                int image = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_STORY_IMAGE));

                List<Scene> scenes = getScenesForStory(id, db);

                Story story = new Story(id, title, image, scenes);
                stories.add(story);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return stories;
    }

    private List<Scene> getScenesForStory(long storyId, SQLiteDatabase db) {
        List<Scene> scenes = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SCENES + " WHERE " + COLUMN_SCENE_STORY_ID + " = " + storyId;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(COLUMN_SCENE_ID);
                int titleIndex = cursor.getColumnIndex(COLUMN_SCENE_TITLE);
                int imageIndex = cursor.getColumnIndex(COLUMN_SCENE_IMAGE);
                int textIndex = cursor.getColumnIndex(COLUMN_SCENE_TEXT);

                int id = cursor.getInt(idIndex);
                String title = cursor.getString(titleIndex);
                int image = cursor.getInt(imageIndex);
                String text = cursor.getString(textIndex);

                if (idIndex != -1 && titleIndex != -1 && imageIndex != -1 && textIndex != -1) {
                    Scene scene = new Scene(id, image, text);
                    scenes.add(scene);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();

        return scenes;
    }
}
