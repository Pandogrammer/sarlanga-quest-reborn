package com.farguito.sarlanga.menu;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuController {

    private MenuScreen screen;
    private MenuRenderer renderer;
    private int midPointY;
    private float runTime = 0;


    public MenuController(MenuScreen screen, int midPointY) {
        this.screen = screen;
        this.midPointY = midPointY;

    }

    public void update(float delta) {
        runTime += delta;
    }

    public void setRenderer(MenuRenderer renderer) {
        this.renderer = renderer;
    }

    public MenuRenderer getRenderer() {
        return renderer;
    }

    public void startBattle() {
        screen.startBattle();
    }

}
