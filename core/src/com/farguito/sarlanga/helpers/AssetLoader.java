package com.farguito.sarlanga.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {
    public static BitmapFont text, endBattleText, lifeBarText;

    public static Skin textSkin;

    public static Texture explosionTexture, lennethTexture, outlaw, monsters, splash, buttonBarTexture,
            selection, turnTexture, attack, loginButtons;

    public static TextureRegion outlawStanding, arena, turnBar, turnP1, turnP2, turnE1, turnE2, turnE3, turnIndicator, buttonBar,
            attackButtonUp, attackButtonDown, skillButtonUp, skillButtonDown,
            itemButtonUp, itemButtonDown, defendButtonUp, defendButtonDown,
            backButtonUp, backButtonDown, confirmButtonUp, confirmButtonDown;
    //Monsters
    public static TextureRegion rat, yellowImp, chimera, tomberi, purpleBeast;

    public static TextureRegion[] explosionRegions, outlawRegions, lennethRegions, attackRegions;

    public static Animation explosionAnimation, outlawStandingAnm, lennetAnimation, attackAnimation;


    public static void load() {
        text = new BitmapFont(Gdx.files.internal("data/text.fnt"), true);
        endBattleText = new BitmapFont(Gdx.files.internal("data/text.fnt"), true);
        lifeBarText = new BitmapFont(Gdx.files.internal("data/text.fnt"), true);

        textSkin = new Skin(Gdx.files.internal("data/uiskin.json"));

        splash = new Texture(Gdx.files.internal("data/splash.png"));

        loginButtons = new Texture(Gdx.files.internal("data/login_buttons.png"));

        monsters = new Texture(Gdx.files.internal("monsters/monsters.png"));
        outlaw = new Texture(Gdx.files.internal("characters/outlaw.png"));

        buttonBarTexture = new Texture(Gdx.files.internal("battle/button_bar.png"));
        turnTexture = new Texture(Gdx.files.internal("battle/turn_bar.png"));
        selection = new Texture(Gdx.files.internal("battle/selection.png"));
        attack = new Texture(Gdx.files.internal("battle/attack.png"));


        backButtonUp = new TextureRegion(loginButtons, 0, 0, 50, 50);
        backButtonDown = new TextureRegion(loginButtons, 0, 50, 50, 50);
        confirmButtonUp = new TextureRegion(loginButtons, 50, 0, 50, 50);
        confirmButtonDown = new TextureRegion(loginButtons, 50, 50, 50, 50);


        arena = new TextureRegion(new Texture(Gdx.files.internal("battle/arena.png")));
        arena.flip(false, true);

        turnBar = new TextureRegion(turnTexture, 4, 1, 5, 105);

        turnP1 = new TextureRegion(turnTexture, 21, 3, 14, 14);
        turnP1.flip(false, true);
        turnP2 = new TextureRegion(turnTexture, 21, 18, 14, 14);
        turnP2.flip(false, true);

        turnE1 = new TextureRegion(turnTexture, 21, 33, 14, 14);
        turnE1.flip(false, true);
        turnE2 = new TextureRegion(turnTexture, 21, 48, 14, 14);
        turnE2.flip(false, true);
        turnE3 = new TextureRegion(turnTexture, 21, 63, 14, 14);
        turnE3.flip(false, true);

        turnIndicator = new TextureRegion(turnTexture, 24, 84, 12, 7);
        turnIndicator.flip(true, true);

        buttonBar = new TextureRegion(buttonBarTexture, 0, 0, 360, 32);
        attackButtonUp = new TextureRegion(buttonBarTexture, 98, 34, 33, 33);
        attackButtonUp.flip(false, true);
        attackButtonDown = new TextureRegion(buttonBarTexture, 137, 34, 33, 33);
        attackButtonDown.flip(false, true);

        int attackSize = 32;
        attackRegions = new TextureRegion[] {
                new TextureRegion(attack, attackSize*0, 0, attackSize, attackSize),
                new TextureRegion(attack, attackSize*1, 0, attackSize, attackSize),
                new TextureRegion(attack, attackSize*2, 0, attackSize, attackSize),
                new TextureRegion(attack, attackSize*3, 0, attackSize, attackSize),
                new TextureRegion(attack, attackSize*4, 0, attackSize, attackSize),
                new TextureRegion(attack, attackSize*5, 0, attackSize, attackSize)
        };

        for(int i = 0; i < attackRegions.length ; i++){
            attackRegions[i].flip(false, true);
        }

        attackAnimation = new Animation(0.1f, attackRegions);
        attackAnimation.setPlayMode(Animation.PlayMode.NORMAL);


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

        yellowImp = new TextureRegion(monsters, 404, 1420, 55, 48);
        yellowImp.flip(false, true);

        chimera = new TextureRegion(monsters, 17, 1404, 88, 64);
        chimera.flip(false, true);

        tomberi = new TextureRegion(monsters, 560, 1004, 32, 30);
        tomberi.flip(false, true);

        purpleBeast = new TextureRegion(monsters, 214, 1091, 56, 48);
        purpleBeast.flip(false, true);

        outlawStanding = new TextureRegion(outlaw, 124, 3, 26, 31);
        outlawStanding.flip(false, true);
    }

    public static void dispose() {
        text.dispose();
        endBattleText.dispose();
        textSkin.dispose();
        splash.dispose();
        lennethTexture.dispose();
        explosionTexture.dispose();
        explosionTexture.dispose();
        arena.getTexture().dispose();
        monsters.dispose();
        outlaw.dispose();
        buttonBarTexture.dispose();
        selection.dispose();
        turnTexture.dispose();
        attack.dispose();
        loginButtons.dispose();
        lifeBarText.dispose();
    }
}
