package com.farguito.sarlanga.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {
    public static BitmapFont text;

    public static void load() {
        text = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        text.getData().setScale(.25f, -.25f);
    }

    public static void dispose() {
        text.dispose();
    }
}
