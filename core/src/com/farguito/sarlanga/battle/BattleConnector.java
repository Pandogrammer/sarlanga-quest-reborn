package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpStatus;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.CharacterCode;
import com.farguito.sarlanga.actors.MonsterFactory;
import com.farguito.sarlanga.helpers.TextureHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BattleConnector implements HttpResponseListener {

    private URL url = null;
    private ObjectMapper mapper;
    private String charactersResponse;
    private boolean responseError;

    public BattleConnector(){
        try {
            url = new URL(SarlangaQuest.url);
            mapper = new ObjectMapper();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void handleHttpResponse(HttpResponse httpResponse) {
        HttpStatus status = httpResponse.getStatus();
        if (status.getStatusCode() >= 200 && status.getStatusCode() < 300) {
            charactersResponse = httpResponse.getResultAsString();
        } else {
            responseError = true;
        }
    }

    @Override
    public void failed(Throwable t) {

    }

    @Override
    public void cancelled() {

    }


    public void getLevelMonsters(int level) {
        try {
            responseError = false;
            HttpRequest httpPost = new HttpRequest(Net.HttpMethods.POST);
            httpPost.setUrl(url + "battle/getLevelMonsters");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setContent(mapper.writeValueAsString(level));
            Gdx.net.sendHttpRequest(httpPost, BattleConnector.this);
        } catch (Exception e){
            responseError = true;
        }
    }

    public Character[] getMonsters() throws IOException {
        if (charactersResponse != null) {
            CharacterCode[] codes = mapper.readValue(charactersResponse, CharacterCode[].class);
            Character[] characters = new Character[codes.length];
            for(int i = 0; i < codes.length; i++){
                characters[i] = MonsterFactory.getCharacter(codes[i]);
            }
            return characters;
        } else return null;
    }

    public boolean isResponseError() {
        return responseError;
    }
}