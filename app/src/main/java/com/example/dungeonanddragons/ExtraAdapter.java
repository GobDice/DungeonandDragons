package com.example.dungeonanddragons;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExtraAdapter extends RecyclerView.Adapter<ExtraAdapter.ViewHolder>{
    private static final String TAG = "ExtraAdapter";
    DBHelper db_helper;
    SQLiteDatabase db;
    private ArrayList<String> mExtra = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private PatternAdapter.ViewHolder holder;
    private int position;
    private final LayoutInflater inflater;
    private final List<Pattern_for_menu> pattern_for_Extra;
    ExtraAdapter(Context context, List<Pattern_for_menu> pattern,SQLiteDatabase db,DBHelper db_helper) {
        this.pattern_for_Extra = pattern;
        this.inflater = LayoutInflater.from(context);
        this.mContext=context;
        this.db_helper=db_helper;
        this.db=db;

    }
    @Override
    public ExtraAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ExtraAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ExtraAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Pattern_for_menu pattern = pattern_for_Extra.get(position);
        holder.imageView.setImageResource(pattern.getImageMenu());
        holder.contentView.setText(pattern.getContent());
        holder.extraView.setText(pattern.getExtra());
       if(pattern.getLike()==0){holder.button.setBackground(ContextCompat.getDrawable(mContext, R.drawable.like));}
       else{holder.button.setBackground(ContextCompat.getDrawable(mContext, R.drawable.unlike));}
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv =new ContentValues();
                pattern.setLike((pattern.getLike()+1)%2);
                cv.put(DBHelper.LIKE,pattern.getLike());
                db.update(DBHelper.TABLE_NAME,cv,DBHelper.ID+ "=" + pattern.getId(),null);
                if(pattern.getLike()==0){holder.button.setBackground(ContextCompat.getDrawable(mContext, R.drawable.like));}
                else{holder.button.setBackground(ContextCompat.getDrawable(mContext, R.drawable.unlike));}
            }
        });
    }
    @Override
    public int getItemCount() {
        return pattern_for_Extra.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageButton button;
        final ImageView imageView;
        final TextView contentView, extraView;
        ViewHolder(View view){
            super(view);
            button= view.findViewById(R.id.button);
            imageView = view.findViewById(R.id.imageMenu);
            contentView = view.findViewById(R.id.content);
            extraView = view.findViewById(R.id.extra); }}}