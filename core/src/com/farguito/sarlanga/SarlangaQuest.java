package com.farguito.sarlanga;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.login.LoginScreen;
import com.farguito.sarlanga.domain.User;

public class SarlangaQuest extends Game {

	public static final int GAME_WIDTH = 360;
	//public static final String url = "http://192.168.0.7:8080/";
	public static final String url = "https://192.168.0.7:8080/";

	private User user;

	@Override
	public void create() {
        Gdx.input.setCatchBackKey(true);
		AssetLoader.load();
		setScreen(new LoginScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
