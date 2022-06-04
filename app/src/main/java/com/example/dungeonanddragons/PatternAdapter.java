package com.example.dungeonanddragons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.ViewHolder>{
    private static final String TAG = "PatternAdapter";
    private ArrayList<String> mExtra = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private ViewHolder holder;
    private int position;


    interface OnPatternClickListener{
        void onPatternClick(Pattern_for_menu pattern_for_menu, int position);
    }
    private final LayoutInflater inflater;
    private final List<Pattern_for_menu> pattern_for_menus;
    private final OnPatternClickListener onClickListener;


    PatternAdapter(Context context, List<Pattern_for_menu> pattern,OnPatternClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.pattern_for_menus = pattern;
        this.inflater = LayoutInflater.from(context);
        this.mContext=context;
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
            {
                Intent intent = new Intent(v.getContext(),Monsters.class);

                onClickListener.onPatternClick(pattern, position);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return pattern_for_menus.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView contentView, extraView;

        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.imageMenu);
            contentView = view.findViewById(R.id.content);
            extraView = view.findViewById(R.id.extra);
        }
    }

}
