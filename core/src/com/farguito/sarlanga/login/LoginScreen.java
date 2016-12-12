package com.farguito.sarlanga.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.menu.MenuInputHandler;

public class LoginScreen implements Screen {

    private SarlangaQuest game;
    private LoginRenderer renderer;
    private LoginController controller;

    public LoginScreen(SarlangaQuest game){
        this.game = game;

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = SarlangaQuest.GAME_WIDTH;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        controller = new LoginController(this, midPointY);
        renderer = new LoginRenderer(controller, (int) gameWidth, (int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new LoginInputHandler(controller, gameHeight, screenWidth / gameWidth, screenHeight / gameHeight));
        controller.setRenderer(renderer);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        renderer.render(delta);
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
