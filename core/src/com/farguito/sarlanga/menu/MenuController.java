package com.farguito.sarlanga.menu;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.LivingArmor;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.actors.Tomberi;
import com.farguito.sarlanga.domain.User;
import com.farguito.sarlanga.domain.UserConnector;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.helpers.TextureHelper;
import com.farguito.sarlanga.ui.SimpleButton;
import com.farguito.sarlanga.ui.SimpleTextField;

import java.util.ArrayList;
import java.util.List;

import static com.farguito.sarlanga.menu.MenuController.MenuState.MENU;
import static com.farguito.sarlanga.menu.MenuController.MenuState.SELECT_LEVEL;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuController {

    private MenuScreen screen;
    private MenuRenderer renderer;
    private int midPointY;
    private float runTime = 0;

    private MenuState currentState;

    private SimpleTextField monsterFightButton;

    private Character[] characters;

    private SimpleButton character1;
    private SimpleButton character2;

    private SimpleButton backButton;
    private SimpleButton confirmButton;

    private List<SimpleTextField> levels;

    private int selectedLevel;
    private User user;

    public enum MenuState{
        MENU, SELECT_LEVEL;
    }

    public Long getUserLevel() {
        return user.getLevel();
    }

    public void goSelectLevel() {
        currentState = SELECT_LEVEL;
    }

    public void goMenu() {
        currentState = MENU;
    }
    public List<SimpleTextField> getLevelButtons() {
        return levels;
    }

    public void setSelectedLevel(int selectedLevel) {
        this.selectedLevel = selectedLevel;
    }



    public MenuController(MenuScreen screen, int midPointY) {
        currentState = MENU;
        this.screen = screen;
        this.user = screen.getGame().getUser();
        this.characters = screen.getGame().getUserCharacters();
        if(characters == null) initUserCharacters();
        this.selectedLevel = 0;
        this.midPointY = midPointY;
        monsterFightButton = new SimpleTextField("FIGHT", AssetLoader.textSkin, SarlangaQuest.GAME_WIDTH/2-30, 50);
        monsterFightButton.setAlignment(1);
        monsterFightButton.setHeight(60);
        monsterFightButton.setWidth(60);

        backButton = new SimpleButton(SimpleButton.Type.CIRCLE,
                300, 50, AssetLoader.backButtonUp.getRegionWidth(), AssetLoader.backButtonUp.getRegionHeight(),
                AssetLoader.backButtonUp, AssetLoader.backButtonDown);
        confirmButton = new SimpleButton(SimpleButton.Type.CIRCLE,
                300, 125, AssetLoader.confirmButtonUp.getRegionWidth(), AssetLoader.confirmButtonUp.getRegionHeight(),
                AssetLoader.confirmButtonUp, AssetLoader.confirmButtonDown);

        initLevels();
    }

    private void initLevels() {
        levels = new ArrayList<SimpleTextField>();

        for(int i = 1; i <= getUserLevel(); i++){
            SimpleTextField level = new SimpleTextField(""+i, AssetLoader.textSkin);
            level.setAlignment(1);
            levels.add(level);
        }
    }

    public void initUserCharacters() {
        UserConnector userConnector = new UserConnector();
        try {
            userConnector.getUserCharacters(user);
            characters = null;
            int tries = 0;
            int timeout = 15;
            while (!userConnector.isResponseError() && tries < timeout) {
                characters = userConnector.getUserCharactersResponse();
                Thread.sleep(500);
                tries++;
            }
            screen.getGame().setUserCharacters(characters);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if(selectedLevel != 0) {
            renderer.stopMusic();
            screen.startBattle(selectedLevel);
        }
    }

    public SimpleTextField getMonsterFightButton() {
        return monsterFightButton;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public SimpleButton getBackButton() {
        return backButton;
    }

    public SimpleButton getConfirmButton() {
        return confirmButton;
    }

    public boolean isMenu() { return currentState == MENU; }
    public boolean isSelectLevel() { return currentState == SELECT_LEVEL; }

}
