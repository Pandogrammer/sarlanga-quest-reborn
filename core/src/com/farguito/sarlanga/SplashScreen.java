package com.farguito.sarlanga;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.login.LoginScreen;
import com.farguito.sarlanga.tween.SpriteAccessor;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

public class SplashScreen implements Screen {

    private TweenManager manager;
    private SpriteBatch batcher;
    private Sprite sprite;
    private SarlangaQuest game;

    public SplashScreen(SarlangaQuest game) {
        this.game = game;
    }

    @Override
    public void show() {
        sprite = new Sprite(AssetLoader.logo);
        sprite.setColor(1, 1, 1, 0);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        float desiredWidth = width * .8f;
        float scale = desiredWidth / sprite.getWidth();

        sprite.setSize(sprite.getWidth() * scale, sprite.getHeight() * scale);
        sprite.setPosition((width / 2) - (sprite.getWidth() / 2), (height / 2)
                - (sprite.getHeight() / 2));
        setupTween();
        batcher = new SpriteBatch();
    }

    private void setupTween() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        manager = new TweenManager();

        TweenCallback cb = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                game.setScreen(new LoginScreen(game));
            }
        };
        TweenCallback sound = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                AssetLoader.splashSound.play();
            }
        };

        Timeline.createSequence()
                .push(Tween.to(sprite, SpriteAccessor.ALPHA, 1f)
                        .target(1)
                        .ease(TweenEquations.easeInExpo)
                        .setCallback(sound).setCallbackTriggers(TweenCallback.COMPLETE))
                .push(Tween.to(sprite, SpriteAccessor.ALPHA, 2f)
                        .target(0)
                        .setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE))
                .start(manager);

    }

    @Override
    public void render(float delta) {
        manager.update(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        sprite.draw(batcher);
        batcher.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}
