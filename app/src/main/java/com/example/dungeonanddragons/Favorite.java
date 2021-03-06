package com.example.dungeonanddragons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.QwertyKeyListener;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;

public class Favorite extends AppCompatActivity  {
    DBHelper db_helper;
    SQLiteDatabase db;
    ArrayList<Pattern_for_menu> pattern_for_menus = new ArrayList<Pattern_for_menu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = getBaseContext().openOrCreateDatabase(DBHelper.DATABASE_NAME, MODE_PRIVATE, null);
        db_helper = new DBHelper(this);
        db_helper.onCreate(db);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.list);
        Cl_hop();
        PatternAdapter.OnPatternClickListener patternClickListener = new PatternAdapter.OnPatternClickListener() {
            @Override
            public void onPatternClick(Pattern_for_menu pattern_for_menu, int position) {
            }
        };
        PatternAdapter adapter = new PatternAdapter(this, pattern_for_menus,patternClickListener,db_helper,db,2);
        recyclerView.setAdapter(adapter);
    }
    void Cl_hop(){
        db=db_helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME + " WHERE "+DBHelper.LIKE+"= 1",null);
        cursor.moveToFirst();
        for (int i=1;i<cursor.getCount()+1;i++){
           Pattern_for_menu pattern_for_menu=new Pattern_for_menu(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4));
           cursor.moveToNext();
           pattern_for_menus.add(pattern_for_menu);
        }
        cursor.close();
    }
}