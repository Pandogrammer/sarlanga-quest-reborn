package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.battle.BattleScreen;

public class MenuScreen implements Screen {

    private SarlangaQuest game;
    private MenuRenderer renderer;
    private MenuController controller;
    private float runTime;

    public MenuScreen(SarlangaQuest game){
        this.game = game;

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = SarlangaQuest.GAME_WIDTH;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        controller = new MenuController(this, midPointY);
        renderer = new MenuRenderer(controller, (int) gameWidth, (int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new MenuInputHandler(controller, gameHeight, screenWidth / gameWidth, screenHeight / gameHeight));
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

    public SarlangaQuest getGame() {
        return game;
    }

    public void startBattle(int level) {
        game.setScreen(new BattleScreen(game, level));
    }
}
