package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Net.*;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Chimera;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.actors.PurpleBeast;
import com.farguito.sarlanga.actors.Rat;
import com.farguito.sarlanga.actors.Tomberi;
import com.farguito.sarlanga.actors.YellowImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BattleConnector implements HttpResponseListener {

    private URL url = null;
    private URLConnection conn = null;
    private ObjectMapper mapper = new ObjectMapper();

    public BattleConnector(){
        try {
            url = new URL(SarlangaQuest.url);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
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


    public Character[] getLevelMonsters(int level) {
        Character[] characters = null;
        switch (level){
            case 1 : characters = new Character[]{
                    new Rat(),new Rat(),new Rat()
            }; break;
            case 2 : characters = new Character[]{
                    new Outlaw(), new Outlaw()
            }; break;
            case 3 : characters = new Character[]{
                    new Rat(), new YellowImp(), new Rat()
            }; break;
            case 4 : characters = new Character[]{
                    new YellowImp(), new Tomberi()
            }; break;
            case 5 : characters = new Character[]{
                    new Outlaw(), new PurpleBeast(), new Outlaw()
            }; break;
            case 6 : characters = new Character[]{
                    new Chimera()
            }; break;
        }
        return characters;
    }
}