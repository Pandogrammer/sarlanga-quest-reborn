package com.farguito.sarlanga.battle;

import com.badlogic.gdx.InputProcessor;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.List;


public class BattleInputHandler implements InputProcessor {

    private List<SimpleButton> menuButtons;
    private BattleController controller;

    private float scaleFactorX;
    private float scaleFactorY;

    public BattleInputHandler(BattleController controller, float scaleFactorX,
                              float scaleFactorY) {
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

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        for(BattleCharacter battleCharacter : controller.getRenderer().getBattleCharacters()){
            System.out.println(battleCharacter.getBounds());
            if(battleCharacter.getBounds().contains(screenX, screenY)){
                battleCharacter.setSelected(true);
            } else {
                battleCharacter.setSelected(false);
            }
        }
        System.out.println(screenX);
        System.out.println(screenY);
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


    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }

}
