package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.battle.TextureHelper;
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
    private TextureRegion character1, character2;

    // Tween stuff

    // Buttons
    private List<SimpleButton> menuButtons;

    public MenuRenderer(MenuController controller, int gameWidth,  int gameHeight, int midPointY) {
        this.controller = controller;

        this.midPointY = midPointY;

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
        character1 = TextureHelper.getRegion(controller.getCharacters()[0]);
        //character1.flip(false, true);
        character2 = TextureHelper.getRegion(controller.getCharacters()[1]);
        //character2.flip(false, true);
    }


    public void render(float delta, float runTime) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        batcher.disableBlending();

        batcher.draw(splash, 0, 0);
        batcher.enableBlending();

        controller.getMonsterFightButton().draw(batcher,1);
        batcher.draw(character1, 100, 175, character1.getRegionWidth(), -character1.getRegionHeight());
        batcher.draw(character2, 200, 175, character2.getRegionWidth(), -character2.getRegionHeight());

        batcher.end();
    }
}
