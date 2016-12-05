package com.farguito.sarlanga.menu;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.farguito.sarlanga.helpers.AssetLoader;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuController {

    private MenuRenderer renderer;
    private int midPointY;
    private float runTime = 0;
    private TextField username;
    private TextField password;

    public MenuController(int midPointY) {
        this.midPointY = midPointY;
        username = new TextField("USERNAME", AssetLoader.textSkin);
        password = new TextField("PASSWORD", AssetLoader.textSkin);
        password.setPasswordMode(true);

    }

    public void update(float delta) {
        runTime += delta;
    }

    public void setRenderer(MenuRenderer renderer) {
        this.renderer = renderer;
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getPassword() {
        return password;
    }
}
