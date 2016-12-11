package com.farguito.sarlanga.battle;

import com.badlogic.gdx.InputProcessor;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;


public class BattleInputHandler implements InputProcessor {

    private List<SimpleButton> menuButtons;

    private SimpleButton attackButton;
    private SimpleButton skillButton;
    private SimpleButton itemButton;
    private SimpleButton defendButton;

    private BattleController controller;

    private float scaleFactorX;
    private float scaleFactorY;

    public BattleInputHandler(BattleController controller, float gameHeight, float scaleFactorX,
                              float scaleFactorY) {
        this.controller = controller;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        menuButtons = new ArrayList<SimpleButton>();
        attackButton = new SimpleButton(
                10, gameHeight-AssetLoader.attackButtonUp.getRegionHeight()-10,
                AssetLoader.attackButtonUp.getRegionWidth(),
                AssetLoader.attackButtonUp.getRegionHeight(),
                AssetLoader.attackButtonUp,
                AssetLoader.attackButtonDown);
        menuButtons.add(attackButton);

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

        if (controller.isPlayerTurn()) {
            for (BattleCharacter battleCharacter : controller.getBattleCharacters()) {
                if(battleCharacter.isAlive() && battleCharacter.isTouchDown(screenX, screenY)){
                    controller.setSelectedCharacter(battleCharacter);
                }
            }
            if(attackButton.isTouchDown(screenX, screenY)){
                if(controller.getSelectedCharacter() != null)
                    controller.doAttack();
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        attackButton.isTouchUp(screenX, screenY);

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

    public List<SimpleButton> getMenuButtons() {
        return menuButtons;
    }
}
