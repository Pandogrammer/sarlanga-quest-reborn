package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Latharia on 11/12/2016.
 */

public class BattleConnector implements Net.HttpResponseListener {

    private URL url = null;
    private URLConnection conn = null;

    public BattleConnector(){
        try {
            url = new URL("http://192.168.0.7/hola");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void sayHi(){
        // LibGDX NET CLASS
        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl("http://192.168.0.7:8080/hola");
        httpPost.setHeader("Content-Type", "application/json");
        Gdx.net.sendHttpRequest(httpPost, BattleConnector.this);
    }

    @Override
    public void handleHttpResponse(Net.HttpResponse httpResponse) {
        ObjectMapper mapper = new ObjectMapper();

//        User obj = null;
//        try {
//            obj = mapper.readValue(httpResponse.getResultAsString(), User.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(obj.getUsername()+" "+obj.getPassword());
    }

    @Override
    public void failed(Throwable t) {

    }

    @Override
    public void cancelled() {

    }

}
