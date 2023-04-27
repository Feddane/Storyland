package com.example.storyland;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StorylandDBHelper extends SQLiteOpenHelper {
    // Nom et version de la base de données
    private static final String DATABASE_NAME = "storyland.db";
    private static final int DATABASE_VERSION = 1;

    // Table Histoires
    public static final String TABLE_HISTOIRES = "histoires";
    public static final String COLUMN_HISTOIRE_ID = "id";
    public static final String COLUMN_HISTOIRE_TITRE = "titre";
    public static final String COLUMN_HISTOIRE_IMAGE = "image";

    // Table Scenes
    public static final String TABLE_SCENES = "scenes";
    public static final String COLUMN_SCENE_ID = "id";
    public static final String COLUMN_SCENE_IMAGE = "image";
    public static final String COLUMN_SCENE_TEXTE = "texte";
    public static final String COLUMN_SCENE_HISTOIRE_ID = "histoire_id";

    // Requêtes SQL pour la création des tables
    private static final String SQL_CREATE_TABLE_HISTOIRES = "CREATE TABLE " + TABLE_HISTOIRES + " ("
            + COLUMN_HISTOIRE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_HISTOIRE_TITRE + " TEXT,"
            + COLUMN_HISTOIRE_IMAGE + " BLOB"
            + ")";

    private static final String SQL_CREATE_TABLE_SCENES = "CREATE TABLE " + TABLE_SCENES + " ("
            + COLUMN_SCENE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_SCENE_IMAGE + " BLOB,"
            + COLUMN_SCENE_TEXTE + " TEXT,"
            + COLUMN_SCENE_HISTOIRE_ID + " INTEGER,"
            + " FOREIGN KEY (" + COLUMN_SCENE_HISTOIRE_ID + ") REFERENCES " + TABLE_HISTOIRES + " (" + COLUMN_HISTOIRE_ID + ")"
            + ")";

    public StorylandDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création des tables
        db.execSQL(SQL_CREATE_TABLE_HISTOIRES);
        db.execSQL(SQL_CREATE_TABLE_SCENES);

        // Ajout des données de test
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_HISTOIRE_TITRE, "Histoire 1");
        cv.put(COLUMN_HISTOIRE_IMAGE, "story1");
        long histoireId = db.insert(TABLE_HISTOIRES, null, cv);

        cv = new ContentValues();
        cv.put(COLUMN_SCENE_IMAGE, "story1");
        cv.put(COLUMN_SCENE_TEXTE, "Texte de la scène 1");
        cv.put(COLUMN_SCENE_HISTOIRE_ID, histoireId);
        db.insert(TABLE_SCENES, null, cv);


        cv = new ContentValues();
        cv.put(COLUMN_SCENE_IMAGE, "story2");
        cv.put(COLUMN_SCENE_TEXTE, "Texte de la scène 2");
        cv.put(COLUMN_SCENE_HISTOIRE_ID, histoireId);
        db.insert(TABLE_SCENES, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Suppression des tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTOIRES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCENES);
        // Création des nouvelles tables
        onCreate(db);
    }
}
