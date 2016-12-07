package com.farguito.sarlanga;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.menu.MenuScreen;

public class SarlangaQuest extends Game {

	public static final int GAME_WIDTH = 360;

	@Override
	public void create() {
        Gdx.input.setCatchBackKey(true);
		AssetLoader.load();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

}
