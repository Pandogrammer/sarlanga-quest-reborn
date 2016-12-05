package com.farguito.sarlanga;


import com.badlogic.gdx.Game;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.menu.MenuScreen;

public class SarlangaQuest extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
