package com.farguito.sarlanga.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class CustomText {

    BitmapFont font;
    String text;
    float x, y;

    public CustomText(BitmapFont font, String text, float x, float y) {
        this.font = font;
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getText() {
        return text;
    }

    public void setY(float y) {
        this.y = y;
    }

}
