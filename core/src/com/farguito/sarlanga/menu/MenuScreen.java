package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farguito.sarlanga.SarlangaQuest;

public class MenuScreen implements Screen {

    private SarlangaQuest game;
    private MenuRenderer renderer;
    private MenuController controller;
    private float runTime;

    public MenuScreen(SarlangaQuest game){
        this.game = game;

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        controller = new MenuController(midPointY);
        Gdx.input.setInputProcessor(new MenuInputHandler(controller, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new MenuRenderer(controller, (int) gameHeight, midPointY);
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
}
