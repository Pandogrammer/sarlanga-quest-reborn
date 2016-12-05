package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.List;

public class MenuInputHandler implements InputProcessor {


    private List<SimpleButton> menuButtons;
    private CharacterNameInputListener inputListener;
    private MenuController controller;

    private float scaleFactorX;
    private float scaleFactorY;

    public MenuInputHandler(MenuController controller, float scaleFactorX,
                            float scaleFactorY) {
        inputListener  = new CharacterNameInputListener(controller);
        this.controller = controller;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.input.getTextInput(inputListener, null, null, null);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
