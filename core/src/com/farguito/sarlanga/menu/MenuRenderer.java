package com.farguito.sarlanga.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.farguito.sarlanga.helpers.TextureHelper;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleButton;
import com.farguito.sarlanga.ui.SimpleTextField;

import java.util.List;

/**
 * Created by Latharia on 04/12/2016.
 */

public class MenuRenderer {

    private int gameHeight;

    private MenuController controller;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private Texture splash;

    private int midPointY;

    // Game Objects

    // Game Assets
    private TextureRegion character1, character2;

    // Tween stuff

    // Buttons
    private List<SimpleTextField> levels;

    public MenuRenderer(MenuController controller, int gameWidth,  int gameHeight, int midPointY) {
        this.controller = controller;
        this.midPointY = midPointY;
        this.gameHeight = gameHeight;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        initAssets();
        levels = controller.getLevelButtons();
        initLevels();
    }

    private void initLevels() {
        float width = 30, height = 30, x = 10, y = gameHeight-height-10;

        for(SimpleTextField level : levels){
            level.setPosition(x, y);
            level.setWidth(width);
            level.setHeight(height);

            x+=width+10;

            if(x > 200) {
                x = 10;
                y-=height+10;
            }
        }
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

        if(controller.isMenu()) {
            drawMenu();
        } else if(controller.isSelectLevel()){
            drawSelectLevel();
        } 

        if(!controller.isMenu()) {
            controller.getBackButton().draw(batcher);
            controller.getConfirmButton().draw(batcher);
        }

        batcher.end();
    }

    private void drawSelectLevel() {
        for(SimpleTextField level : levels){
            level.draw(batcher, 1);
        }
    }

    private void drawMenu() {
        controller.getMonsterFightButton().draw(batcher,1);
        batcher.draw(character1, 100, 175, character1.getRegionWidth(), -character1.getRegionHeight());
        batcher.draw(character2, 200, 175, character2.getRegionWidth(), -character2.getRegionHeight());
    }
}
