package com.farguito.sarlanga.menu;

import com.badlogic.gdx.InputProcessor;

public class MenuInputHandler implements InputProcessor {


    private MenuController controller;

    private float scaleFactorX;
    private float scaleFactorY;
    private float gameHeight;

    public MenuInputHandler(MenuController controller, float gameHeight, float scaleFactorX,
                            float scaleFactorY) {

        this.controller = controller;
        this.gameHeight = gameHeight;
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

        screenY = (int) gameHeight-screenY;

        if(controller.isMenu()) {
            if (controller.getMonsterFightButton().isTouchDown(screenX, screenY))
                controller.goSelectLevel();
        } else if (controller.isSelectLevel()){
            for(int i = 0; i < controller.getLevelButtons().size(); i++){
                if(controller.getLevelButtons().get(i).isTouchDown(screenX,screenY))
                    controller.setSelectedLevel(i+1);
            }
        }

        if(!controller.isMenu()) {
            controller.getBackButton().isTouchDown(screenX, screenY);
            controller.getConfirmButton().isTouchDown(screenX, screenY);
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        screenY = (int) gameHeight-screenY;
        if(!controller.isMenu()) {
            if(controller.getBackButton().isTouchUp(screenX, screenY))
                controller.goMenu();
            if(controller.getConfirmButton().isTouchUp(screenX, screenY)){
                if(controller.isSelectLevel()) controller.startBattle();
            }

        }
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
