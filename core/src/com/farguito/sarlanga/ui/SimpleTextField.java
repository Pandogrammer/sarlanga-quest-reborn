package com.farguito.sarlanga.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created by Latharia on 11/12/2016.
 */

public class SimpleTextField extends TextField {

    private float x, y, width, height;

    private Rectangle bounds;

    private boolean isPressed = false;

    public SimpleTextField(String text, Skin skin, float x, float y) {
        super(text, skin);
        this.x = x;
        this.y = y;
        super.setPosition(x, y);
        this.width = this.getWidth();
        this.height = this.getHeight();
        bounds = new Rectangle(x, y, width, height);
    }

    public SimpleTextField(String text, Skin skin){
        super(text, skin);
        this.width = this.getWidth();
        this.height = this.getHeight();
        bounds = new Rectangle(0, 0, width, height);
    }

    public SimpleTextField(String text, Skin skin, String styleName) {
        super(text, skin, styleName);
    }

    public SimpleTextField(String text, TextFieldStyle style) {
        super(text, style);
    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public boolean isTouchDown(int screenX, int screenY) {
        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }

        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {

        // It only counts as a touchUp if the button is in a pressed state.
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            return true;
        }

        // Whenever a finger is released, we will cancel any presses.
        isPressed = false;
        return false;
    }

    public void setPosition(float x, float y){
        super.setPosition(x, y);
        bounds.setPosition(x, y);
    }

    public void setWidth(float width){
        super.setWidth(width);
        bounds.setWidth(width);
    }

    public void setHeight(float height){
        super.setHeight(height);
        bounds.setHeight(height);
    }
}
