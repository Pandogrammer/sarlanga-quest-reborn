package com.farguito.sarlanga.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {
    public static BitmapFont text;
    public static Skin textSkin;

    public static void load() {
        text = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        textSkin = new Skin(Gdx.files.internal("data/uiskin.json"));
        text.getData().setScale(.25f, -.25f);
    }

    public static void dispose() {
        text.dispose();
        textSkin.dispose();
    }
}
