package com.farguito.sarlanga.domain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.*;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class UserConnector implements HttpResponseListener {

    private URL url = null;
    private URLConnection conn = null;
    private ObjectMapper mapper = new ObjectMapper();


    public UserConnector(){
        try {
            url = new URL(SarlangaQuest.url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Character[] getSelectedCharacters(){
        return new Character[]{
                new Outlaw(),
                new Outlaw()
        };
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

    }

    @Override
    public void failed(Throwable t) {

    }

    @Override
    public void cancelled() {

    }
}
