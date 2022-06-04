package com.example.dungeonanddragons;

import android.content.Context;

public class Pattern_for_menu {
    private Context pContext;
    private String content;
    private String extra;
    private int imageMenu;


    public Pattern_for_menu(String content, String extra, int imageMenu,Context pContext){
        this.pContext=pContext;
        this.content=content;
        this.extra=extra;
        this.imageMenu=imageMenu;
    }
    public Context pContext() { return this.pContext; }

    public void pContext(Context pContext) { this.pContext = pContext;}

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
