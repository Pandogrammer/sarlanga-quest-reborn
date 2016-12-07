package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Input.TextInputListener;

/**
 * Created by Latharia on 05/12/2016.
 */

public class CharacterNameInputListener implements TextInputListener {

    MenuController controller;

    public CharacterNameInputListener(MenuController controller) {
        this.controller = controller;
    }

    @Override
    public void input (String text) {
            controller.getUsername().setText(text);
    }

    @Override
    public void canceled () {
    }
}