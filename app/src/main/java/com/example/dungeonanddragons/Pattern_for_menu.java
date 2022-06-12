package com.example.dungeonanddragons;

import android.content.Context;
import android.widget.Button;

public class Pattern_for_menu {
    private String content;
    private String extra;
    private int imageMenu;
    private Button button;


    public Pattern_for_menu(String content, String extra, int imageMenu){
        this.content=content;
        this.extra=extra;
        this.imageMenu=imageMenu;
        this.button=button;
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


}
