package com.farguito.sarlanga.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.List;

/**
 * Created by Latharia on 11/12/2016.
 */

public class LoginRenderer {

    private LoginController controller;
    private OrthographicCamera cam;

    private SpriteBatch batcher;

    private Texture splash;

    private int midPointY;

    // Game Objects

    // Game Assets

    // Tween stuff

    // Buttons
    private List<SimpleButton> menuButtons;


    public LoginRenderer(LoginController controller, int gameWidth, int gameHeight, int midPointY) {
        this.controller = controller;

        this.midPointY = midPointY;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        initAssets();

    }

    private void initAssets() {
        splash = AssetLoader.splash;
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        batcher.disableBlending();
        batcher.draw(splash, 0, 0);

        batcher.enableBlending();

        if(controller.isMenu()) {
            drawMenu();
        } else if(controller.isLogin()){
            drawLogin();
        } else if(controller.isRegister()){
            drawRegister();
        }

        if(!controller.isMenu()) {
            controller.getBackButton().draw(batcher);
            controller.getConfirmButton().draw(batcher);
        }
        batcher.end();
    }

    private void drawRegister() {
        drawUsername();
        drawPassword();
        drawConfirm();
    }

    private void drawLogin() {
        drawUsername();
        drawPassword();
    }


    private void drawConfirm() {
        controller.getConfirmPassword().draw(batcher, 1);
        controller.getConfirmPasswordLabel().draw(batcher, 1);
    }

    private void drawPassword() {
        controller.getPassword().draw(batcher, 1);
        controller.getPasswordLabel().draw(batcher, 1);
    }

    private void drawUsername() {
        controller.getUsername().draw(batcher, 1);
        controller.getUsernameLabel().draw(batcher, 1);
    }

    private void drawMenu() {
        controller.getTitle().draw(batcher, 1);
        controller.getLogin().draw(batcher, 1);
        controller.getRegister().draw(batcher, 1);

    }
}
