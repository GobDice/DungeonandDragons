package com.example.dungeonanddragons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Race extends AppCompatActivity {
    ArrayList<Pattern_for_menu> pattern_for_Extra = new ArrayList<Pattern_for_menu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        ExtraAdapter adapter = new ExtraAdapter(this, pattern_for_Extra);

        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        pattern_for_Extra.add(new Pattern_for_menu ("Человек", "Описание монстров", R.drawable.dragon));
        pattern_for_Extra.add(new Pattern_for_menu ("Орк", "Буэнос-Айрес", R.drawable.race));
        // pattern_for_Monster.add(new Pattern_for_menu ("calculator", "Буэнос-Айрес", R.drawable.race));
    }
}