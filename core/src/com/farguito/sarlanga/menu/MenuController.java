package com.farguito.sarlanga.menu;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuController {

    private MenuRenderer renderer;
    private int midPointY;
    private float runTime = 0;
    private String text;

    public MenuController(int midPointY) {
        this.midPointY = midPointY;
        this.text = "";
    }

    public void setRenderer(MenuRenderer renderer) {
        this.renderer = renderer;
    }

    public void update(float delta) {
        runTime += delta;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
