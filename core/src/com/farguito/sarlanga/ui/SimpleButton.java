package com.farguito.sarlanga.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

public class SimpleButton {

    private float x, y, width, height;

    private TextureRegion buttonUp;
    private TextureRegion buttonDown;

    private Shape2D bounds;

    private boolean isPressed = false;

    private Type type;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public enum Type {
        CIRCLE,  RECTANGLE
    }

    public SimpleButton(Type type, float x, float y, float width, float height,
                        TextureRegion buttonUp, TextureRegion buttonDown) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;
        this.type = type;

        switch (type) {
            case CIRCLE:
                bounds = new Circle(x + width / 2, y + height / 2, width / 2);
                break;
            case RECTANGLE:
                bounds = new Rectangle(x, y, width, height);
                break;
        }

    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public void draw(SpriteBatch batcher) {
        if (isPressed) {
            batcher.draw(buttonDown, x, y, width, height);
        } else {
            batcher.draw(buttonUp, x, y, width, height);
        }
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
        this.x = x;
        this.y = y;
        switch(type){
            case CIRCLE: ((Circle) bounds).setPosition(x, y);
                break;
            case RECTANGLE: ((Rectangle) bounds).setPosition(x, y);
                break;
        }
    }

}

