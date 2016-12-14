package com.farguito.sarlanga.login;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.farguito.sarlanga.ui.SimpleTextField;

public class LoginInputHandler implements InputProcessor {

    private LoginController controller;

    private float scaleFactorX;
    private float scaleFactorY;
    private float gameHeight;

    public LoginInputHandler(LoginController controller, float gameHeight, float scaleFactorX, float scaleFactorY) {

        this.controller = controller;
        this.gameHeight = gameHeight;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

    }

    @Override
    public boolean keyDown(int keycode) {
        if(controller.getStage().getKeyboardFocus() != null) {
            SimpleTextField textfield = ((SimpleTextField) controller.getStage().getKeyboardFocus());
            if(keycode == Input.Keys.BACKSPACE)
                if(textfield.getText().length()>0)
                textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if(controller.getStage().getKeyboardFocus() != null) {
            SimpleTextField textfield = ((SimpleTextField) controller.getStage().getKeyboardFocus());
            textfield.appendText(""+character);
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        screenY = (int) gameHeight-screenY;

        controller.getStage().unfocusAll();
        Gdx.input.setOnscreenKeyboardVisible(false);

        if(!controller.isWaiting()) {
            if (controller.isMenu()) {
                if (controller.getLogin().isTouchDown(screenX, screenY))
                    controller.goLogin();
                else if (controller.getRegister().isTouchDown(screenX, screenY))
                    controller.goRegister();
            } else if (controller.isLogin()) {
                if (controller.getUsername().isTouchDown(screenX, screenY))
                    setFocusAndShowKeyboard(controller.getUsername());
                else if (controller.getPassword().isTouchDown(screenX, screenY))
                    setFocusAndShowKeyboard(controller.getPassword());
                else if (controller.getConfirmButton().isTouchDown(screenX, screenY)) ;
            } else if (controller.isRegister()) {
                if (controller.getUsername().isTouchDown(screenX, screenY))
                    setFocusAndShowKeyboard(controller.getUsername());
                else if (controller.getPassword().isTouchDown(screenX, screenY))
                    setFocusAndShowKeyboard(controller.getPassword());
                else if (controller.getConfirmPassword().isTouchDown(screenX, screenY))
                    setFocusAndShowKeyboard(controller.getConfirmPassword());
                else if (controller.getConfirmButton().isTouchDown(screenX, screenY)) ;
            }

            if (!controller.isMenu()) {
                controller.getBackButton().isTouchDown(screenX, screenY);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        screenY = (int) gameHeight-screenY;
        if(!controller.isWaiting()) {
            if (!controller.isMenu()) {
                if (controller.getBackButton().isTouchUp(screenX, screenY))
                    controller.goMenu();
                if (controller.getConfirmButton().isTouchUp(screenX, screenY)) {
                    if (controller.isRegister()) controller.startRegister();
                    else if (controller.isLogin()) controller.startLogin();
                }

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

    private void setFocusAndShowKeyboard(Actor actor){
        controller.getStage().setKeyboardFocus(actor);
        Gdx.input.setOnscreenKeyboardVisible(true);
    }
}
