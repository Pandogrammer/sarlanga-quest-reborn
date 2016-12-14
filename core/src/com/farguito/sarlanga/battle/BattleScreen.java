package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.menu.MenuScreen;

/**
 * Created by Latharia on 06/12/2016.
 */

public class BattleScreen implements Screen {

    private SarlangaQuest game;
    private BattleRenderer renderer;
    private BattleController controller;
    private float runTime;
    private int level;

    public BattleScreen (SarlangaQuest game, int level){
        this.game = game;
        this.level = level;

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = SarlangaQuest.GAME_WIDTH;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        controller = new BattleController(this);
        Gdx.input.setInputProcessor(new BattleInputHandler(controller, gameHeight, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new BattleRenderer(controller, gameHeight, gameWidth);
        controller.setRenderer(renderer);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        controller.update(delta);
        renderer.render(delta, runTime);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void goMenu() {
        game.setScreen(new MenuScreen(game));
    }

    public int getLevel(){
        return level;
    }

    public SarlangaQuest getGame() {
        return game;
    }
}
