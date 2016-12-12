package com.farguito.sarlanga.domain;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.*;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.login.LoginConnector;
import com.fasterxml.jackson.databind.ObjectMapper;

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
