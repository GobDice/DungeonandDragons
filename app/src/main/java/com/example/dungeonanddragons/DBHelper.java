package com.example.dungeonanddragons;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "app";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "tabs";


    static final String ID = "id";
    static final String CONTENT = "content";
    static final String EXTRA = "extra";
    static final String IMG="img";
    static final String LIKE="mlike";
    static final String TYPE="type";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String request =  "CREATE TABLE  IF NOT EXISTS " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CONTENT + " TEXT, " +
                EXTRA + " TEXT, "+
                IMG+" INTEGER, "+
                LIKE+" INTEGER, "+
                TYPE+" TEXT "+")" + "; ";
        db.execSQL(request);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
