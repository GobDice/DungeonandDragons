package com.example.dungeonanddragons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Monsters extends AppCompatActivity {
    ArrayList<Pattern_for_menu> pattern_for_Extra = new ArrayList<Pattern_for_menu>();
    DBHelper db_helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = getBaseContext().openOrCreateDatabase(DBHelper.DATABASE_NAME, MODE_PRIVATE, null);
        db_helper = new DBHelper(this);
        db_helper.onCreate(db);
        setContentView(R.layout.activity_monsters);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        ExtraAdapter adapter = new ExtraAdapter(this, pattern_for_Extra,db,db_helper);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME + " WHERE "+DBHelper.TYPE+" = 'M' ",null);
        cursor.moveToFirst();
        for (int i=1;i<cursor.getCount()+1;i++){
            Pattern_for_menu pattern_for_menu=new Pattern_for_menu(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4));
            cursor.moveToNext();
            pattern_for_Extra.add(pattern_for_menu);
        }
        cursor.close();
    }
}