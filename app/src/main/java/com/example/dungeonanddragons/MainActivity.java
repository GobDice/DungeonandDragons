package com.example.dungeonanddragons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

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
        db = db_helper.getReadableDatabase();
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

        pattern_for_menus.add(new Pattern_for_menu (0,"Монстры", "Описание монстров", R.drawable.dragon,0));
        pattern_for_menus.add(new Pattern_for_menu (1,"Race", "Информация о рассах и их оссобеностях", R.drawable.race,0));
        pattern_for_menus.add(new Pattern_for_menu (2,"Favorite", "То что вам понравилось и может пригодиться", R.drawable.orc_img,0));
        db=db_helper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME,null);
        if(cursor.getCount()==0){
            insert("Goblin", "20 hp. 3 dmg.", R.drawable.goblin,"M",0);
            insert("Goblit", "20 hp. 3 dmg.", R.drawable.goblit,"M",0);
            insert("Snake", "10 hp. 2 dmg.+poisn.", R.drawable.snake,"M",0);
            insert("Werewolf", "100 hp. 10 dmg.", R.drawable.werewolf,"M",0);
            insert("Frog", "1 hp. 0 dmg.", R.drawable.frog_img,"M",0);
            insert("Sea horse", "2 hp. 0 dmg.", R.drawable.sea_horse_img,"M",0);
            insert("Scorpion", "3 hp. 2 dmg.", R.drawable.scorpion_img,"M",0);
            insert("Человек", "+1 к кажд. хар.", R.drawable.human_img,"R",0);
            insert("Творение божье", "one +2 and +1", R.drawable.godder_img,"R",0);
            insert("Орк", "+2 str.+1 hp. ", R.drawable.orc_img,"R",0);
            insert("Эльф", "+2 int.+1 agl.", R.drawable.elf_img,"R",0);
            insert("Змее-люд", "+2 agl. +1 str.", R.drawable.snake_human_img,"R",0);
            insert("Дварф", "+3 hp.", R.drawable.dwarf_img,"R",0);
        }
        cursor.close();
    }
    void insert(String content,String extra,int img,String type,int like) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.CONTENT,content);
        cv.put(DBHelper.EXTRA,extra);
        cv.put(DBHelper.IMG,img);
        cv.put(DBHelper.TYPE,type);
        cv.put(DBHelper.LIKE,like);
        db.insert(DBHelper.TABLE_NAME,null,cv);
    }

}