package com.farguito.sarlanga.login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.net.HttpStatus;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static com.farguito.sarlanga.login.LoginConnector.Operation.LOGIN;
import static com.farguito.sarlanga.login.LoginConnector.Operation.REGISTER;

/**
 * Created by Latharia on 11/12/2016.
 */

public class LoginConnector implements HttpResponseListener {

    private URL url = null;
    private URLConnection conn = null;
    private ObjectMapper mapper = new ObjectMapper();
    private Operation operation;
    private String loginResponse;
    private String registerResponse;
    private boolean responseError;
    private boolean waiting;

    public boolean isResponseError() {
        return responseError;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public enum Operation{
        REGISTER, LOGIN
    }


    public LoginConnector(){
        try {
            url = new URL(SarlangaQuest.url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void register(String username, String password) throws JsonProcessingException {
        operation = REGISTER;
        registerResponse = null;
        responseError = false;
        waiting = true;
        HttpRequest httpPost = new HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl(url+"user/register");
        httpPost.setHeader("Content-Type", "application/json");
        User user = new User(username, password);
        httpPost.setContent(mapper.writeValueAsString(user));
        Gdx.net.sendHttpRequest(httpPost, LoginConnector.this);
    }

    public void login(String username, String password) throws JsonProcessingException {
        operation = LOGIN;
        loginResponse = null;
        responseError = false;
        waiting = true;
        HttpRequest httpPost = new HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl(url+"user/login");
        httpPost.setHeader("Content-Type", "application/json");
        User user = new User(username, password);
        httpPost.setContent(mapper.writeValueAsString(user));

        Gdx.net.sendHttpRequest(httpPost, LoginConnector.this);
    }

    @Override
    public void handleHttpResponse(HttpResponse httpResponse) {
        HttpStatus status = httpResponse.getStatus();
        if (status.getStatusCode() >= 200 && status.getStatusCode() < 300) {
            switch (operation){
                case LOGIN:
                    loginResponse = httpResponse.getResultAsString();
                    waiting = false;
                    break;
                case REGISTER:
                    registerResponse = httpResponse.getResultAsString();
                    waiting = false;
                    break;
            }
        } else {
            responseError = true;
            waiting = false;
        }
    }


    public User getLoginResponse() throws IOException {
        if(loginResponse != null) {
            User user = mapper.readValue(loginResponse, User.class);
            return user;
        }
        else return null;
    }

    public User getRegisterResponse() throws IOException {
        if(registerResponse != null) {
            User user = mapper.readValue(registerResponse, User.class);
            return user;
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
