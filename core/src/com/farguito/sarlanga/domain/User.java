package com.farguito.sarlanga.domain;

/**
 * Created by Latharia on 12/12/2016.
 */

public class User {

    Long id;
    String username;
    String password;

    public User(){
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
}