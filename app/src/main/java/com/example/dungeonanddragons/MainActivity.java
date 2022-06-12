package com.example.dungeonanddragons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
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
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        PatternAdapter.OnPatternClickListener patternClickListener = new PatternAdapter.OnPatternClickListener() {
            @Override
            public void onPatternClick(Pattern_for_menu pattern_for_menu, int position) {
            }
        };
        PatternAdapter adapter = new PatternAdapter(this, pattern_for_menus,patternClickListener,db_helper,db,1);
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        pattern_for_menus.add(new Pattern_for_menu ("Монстры", "Описание монстров", R.drawable.dragon));
        pattern_for_menus.add(new Pattern_for_menu ("Race", "Буэнос-Айрес", R.drawable.race));
        pattern_for_menus.add(new Pattern_for_menu ("Favorite", "Буэнос-Айрес", R.drawable.orc_img));

    }

}