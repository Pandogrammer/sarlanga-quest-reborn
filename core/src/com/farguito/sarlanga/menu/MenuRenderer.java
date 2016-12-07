package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
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
    private TextField username;
    private TextField password;

    private Texture splash;

    private int midPointY;

    // Game Objects

    // Game Assets
    private Animation lennethAnimation;

    private Animation explosionAnimation;
    float explosionTime = 0;

    // Tween stuff
//    private TweenManager manager;
//    private Value alpha = new Value();

    // Buttons
    private List<SimpleButton> menuButtons;

    public MenuRenderer(MenuController controller, int gameWidth,  int gameHeight, int midPointY) {
        this.controller = controller;

        this.midPointY = midPointY;

        username = controller.getUsername();
        username.setSize(100, 10);
//        username.getStyle().font.getData().scale(-0.25f);

        password = controller.getPassword();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        initAssets();
    }

    private void initAssets() {
        splash = AssetLoader.splash;
        lennethAnimation = AssetLoader.lennetAnimation;
        explosionAnimation = AssetLoader.explosionAnimation;
    }


    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        batcher.disableBlending();

        batcher.draw(splash, 0, 0);
        batcher.enableBlending();

        if(controller.getTouchCount() < 50)
            batcher.draw(lennethAnimation.getKeyFrame(runTime), 70, 25);
        else {
            batcher.draw(explosionAnimation.getKeyFrame(explosionTime), 50, 25);
            explosionTime += delta;
        }
    /*
        username.setPosition(100, 10);
        username.setSize(username.getText().length()*12, 10);
        username.draw(batcher, 1);

        password.setPosition(100, 50);
        password.setSize(password.getText().length()*12, 10);
        password.draw(batcher, 1);
    */
        batcher.end();
    }
}
