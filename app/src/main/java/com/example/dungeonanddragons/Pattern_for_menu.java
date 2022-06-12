package com.example.dungeonanddragons;

import android.content.Context;
import android.widget.Button;

public class Pattern_for_menu {
    private String content;
    private String extra;
    private int imageMenu;
    private Button button;
    private int mlike;
    private int id;


    public Pattern_for_menu(int id,String content, String extra, int imageMenu,int mlike){
        this.content=content;
        this.extra=extra;
        this.imageMenu=imageMenu;
        this.button=button;
        this.mlike=mlike;
        this.id=id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getImageMenu() {
        return this.imageMenu;
    }

    public void setImageMenu(int imageMenu) {
        this.imageMenu = imageMenu;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return this.mlike;
    }

    public void setLike(int mlike) {
        this.mlike = mlike;
    }
}
