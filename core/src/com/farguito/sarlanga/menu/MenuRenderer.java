package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.List;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuRenderer {

    private MenuController controller;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;

    // Game Objects
//    private Bird bird;
//    private ScrollHandler scroller;
//    private Grass frontGrass, backGrass;
//    private Pipe pipe1, pipe2, pipe3;

    // Game Assets
//    private TextureRegion bg, grass, birdMid, skullUp, skullDown, bar, ready,
//            zbLogo, gameOver, highScore, scoreboard, star, noStar, retry;
//    private Animation birdAnimation;

    // Tween stuff
//    private TweenManager manager;
//    private Value alpha = new Value();

    // Buttons
    private List<SimpleButton> menuButtons;

    public MenuRenderer(MenuController controller, int gameHeight, int midPointY) {
        this.controller = controller;

        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }


    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        batcher.enableBlending();
        controller.getPassword().draw(batcher, 1);
        controller.getUsername().draw(batcher, 1);

        batcher.end();
    }
}
