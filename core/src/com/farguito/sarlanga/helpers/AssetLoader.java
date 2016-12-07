package com.farguito.sarlanga.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {
    public static BitmapFont text;
    public static Skin textSkin;

    public static Texture explosionTexture, lennethTexture, outlaw, monsters, splash, buttonBar, selection;

    public static TextureRegion outlawStanding, rat, arena;

    public static TextureRegion[] explosionRegions, outlawRegions, lennethRegions;

    public static Animation explosionAnimation, outlawStandingAnm, lennetAnimation;


    public static void load() {
        text = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        textSkin = new Skin(Gdx.files.internal("data/uiskin.json"));
        splash = new Texture(Gdx.files.internal("data/splash.png"));

        monsters = new Texture(Gdx.files.internal("monsters/monsters.png"));
        outlaw = new Texture(Gdx.files.internal("characters/outlaw.png"));
        buttonBar = new Texture(Gdx.files.internal("data/button_bar.png"));
        selection = new Texture(Gdx.files.internal("data/selection.png"));


        arena = new TextureRegion(new Texture(Gdx.files.internal("data/arena.png")));
        arena.flip(false, true);

        lennethTexture = new Texture(Gdx.files.internal("characters/lenneth.png"));
        lennethRegions = new TextureRegion[] {
                new TextureRegion(lennethTexture, 1, 4, 49, 50 ),
                new TextureRegion(lennethTexture, 63, 4, 49, 50 ),
                new TextureRegion(lennethTexture, 120, 4, 49, 50 ),
                new TextureRegion(lennethTexture, 175, 4, 49, 50 )
        };

        lennetAnimation = new Animation(0.1f, lennethRegions);
        lennetAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        int explosionSize = 96;
        explosionTexture = new Texture(Gdx.files.internal("explosion.png"));
        explosionRegions = new TextureRegion[] {
                new TextureRegion(explosionTexture, 8, 0, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize+8, 0, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*2+8, 0, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*3+8, 0, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*4+8, 0, explosionSize-8, explosionSize),
                new TextureRegion(explosionTexture, 0, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*2, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*3, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*4, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, 0, explosionSize, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize, explosionSize*2, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*2, explosionSize*2, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*3, explosionSize*2, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, explosionSize*4, explosionSize*2, explosionSize, explosionSize),
                new TextureRegion(explosionTexture, 0, 0, 0, 0),
        };

        explosionAnimation = new Animation(0.095f, explosionRegions);
        explosionAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        outlawRegions = new TextureRegion[] {
                new TextureRegion(outlaw, 124, 3, 26, 31),
                new TextureRegion(outlaw, 124, 43, 26, 31)
        };

        outlawStandingAnm = new Animation(0.2f, outlawRegions);
        outlawStandingAnm.setPlayMode(Animation.PlayMode.LOOP);

        rat = new TextureRegion(monsters, 678, 1569, 31, 30);
        rat.flip(false, true);

        outlawStanding = new TextureRegion(outlaw, 124, 3, 26, 31);
        outlawStanding.flip(false, true);
    }

    public static void dispose() {
        text.dispose();
        textSkin.dispose();
        splash.dispose();
        lennethTexture.dispose();
        explosionTexture.dispose();
        explosionTexture.dispose();
        arena.getTexture().dispose();
        monsters.dispose();
        outlaw.dispose();
        buttonBar.dispose();
        selection.dispose();
    }
}
