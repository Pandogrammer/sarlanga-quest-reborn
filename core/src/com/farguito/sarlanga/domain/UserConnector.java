package com.farguito.sarlanga.domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpStatus;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.CharacterCode;
import com.farguito.sarlanga.actors.MonsterFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class UserConnector implements HttpResponseListener {

    private URL url = null;
    private ObjectMapper mapper = new ObjectMapper();
    private String charactersResponse;
    private boolean responseError;


    public UserConnector(){
        try {
            url = new URL(SarlangaQuest.url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getUserCharacters(User user){
        try {
            responseError = false;
            HttpRequest httpPost = new HttpRequest(HttpMethods.POST);
            httpPost.setUrl(url + "user/getCharacters");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setContent(mapper.writeValueAsString(user));
            Gdx.net.sendHttpRequest(httpPost, UserConnector.this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void unlockLevel(User user){
        try {
            user.setLevel(user.getLevel() + 1);
            HttpRequest httpPost = new HttpRequest(HttpMethods.POST);
            httpPost.setUrl(url + "user/unlockLevel");
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setContent(mapper.writeValueAsString(user));
            Gdx.net.sendHttpRequest(httpPost, UserConnector.this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void handleHttpResponse(HttpResponse httpResponse) {
        HttpStatus status = httpResponse.getStatus();
        if (status.getStatusCode() >= 200 && status.getStatusCode() < 300) {
            mapper.enableDefaultTyping(); // default to using DefaultTyping.OBJECT_AND_NON_CONCRETE
            mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
            charactersResponse = httpResponse.getResultAsString();
            mapper.disableDefaultTyping();
        } else {
            responseError = true;
        }
    }


    public boolean isResponseError() {
        return responseError;
    }

    public Character[] getUserCharactersResponse() throws IOException {
        if(charactersResponse != null) {
            CharacterCode[] codes = mapper.readValue(charactersResponse, CharacterCode[].class);
            Character[] characters = new Character[codes.length];
            for(int i = 0; i < codes.length; i++){
                characters[i] = MonsterFactory.getCharacter(codes[i]);
            }
            return characters;
        }
        else return null;
    }
    @Override
    public void failed(Throwable t) {

    }

    @Override
    public void cancelled() {

    }
}
