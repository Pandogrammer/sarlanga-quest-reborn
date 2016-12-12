package com.farguito.sarlanga.menu;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.domain.UserConnector;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleTextField;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuController {

    private MenuScreen screen;
    private MenuRenderer renderer;
    private int midPointY;
    private float runTime = 0;

    private SimpleTextField monsterFightButton;

    private Character[] characters;

    public enum MenuState{

    }


    public MenuController(MenuScreen screen, int midPointY) {
        this.screen = screen;
        this.midPointY = midPointY;
        initUserCharacters();
        monsterFightButton = new SimpleTextField("MONSTER FIGHT", AssetLoader.textSkin, 50, 50);

    }

    public void initUserCharacters() {
        UserConnector connector = new UserConnector();
        characters = connector.getSelectedCharacters();
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

    public SimpleTextField getMonsterFightButton() {
        return monsterFightButton;
    }

    public Character[] getCharacters() {
        return characters;
    }
}
