package com.example.dungeonanddragons;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.ViewHolder>{
    private static final String TAG = "PatternAdapter";
    DBHelper db_helper;
    SQLiteDatabase db;
    private ArrayList<String> mExtra = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private ViewHolder holder;
    private int position;
    private int key;
    interface OnPatternClickListener{
        void onPatternClick(Pattern_for_menu pattern_for_menu, int position);
    }
    private final LayoutInflater inflater;
    private final List<Pattern_for_menu> pattern_for_menus;
    private final OnPatternClickListener onClickListener;


    PatternAdapter(Context context, List<Pattern_for_menu> pattern,OnPatternClickListener onClickListener,DBHelper db_helper,SQLiteDatabase db,int key) {
        this.onClickListener = onClickListener;
        this.pattern_for_menus = pattern;
        this.inflater = LayoutInflater.from(context);
        this.mContext=context;
        this.db_helper=db_helper;
        this.db=db;
        this.key=key;
    }
    @Override
    public PatternAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatternAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Pattern_for_menu pattern = pattern_for_menus.get(position);
        holder.imageView.setImageResource(pattern.getImageMenu());
        holder.contentView.setText(pattern.getContent());
        holder.extraView.setText(pattern.getExtra());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {   switch (key) {
                case 1:
                Intent intent = new Intent();
                switch (position) {

                    case 0:
                        intent = new Intent(v.getContext(), Monsters.class);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), Race.class);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), Favorite.class);
                        break;
                }


                onClickListener.onPatternClick(pattern, position);
                mContext.startActivity(intent);
                break;
                default:break;
            }}
        });
    }


    @Override
    public int getItemCount() {
        return pattern_for_menus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final Button button;
        final ImageView imageView;
        final TextView contentView, extraView;
        ViewHolder(View view){
            super(view);
            button= view.findViewById(R.id.button);
            button.setVisibility(View.INVISIBLE );
            imageView = view.findViewById(R.id.imageMenu);
            contentView = view.findViewById(R.id.content);
            extraView = view.findViewById(R.id.extra);

        }
    }

}
