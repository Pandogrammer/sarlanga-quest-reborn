package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.farguito.sarlanga.SarlangaQuest;

/**
 * Created by Latharia on 06/12/2016.
 */

public class BattleScreen implements Screen {

    private BattleRenderer renderer;
    private BattleController controller;
    private float runTime;


    public BattleScreen (SarlangaQuest game){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gameWidth = SarlangaQuest.GAME_WIDTH;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);

        controller = new BattleController();
        renderer = new BattleRenderer(controller, (int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new BattleInputHandler(controller, screenWidth / gameWidth, screenHeight / gameHeight));
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
