package com.farguito.sarlanga.battle;

import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.actors.Rat;

/**
 * Created by Latharia on 06/12/2016.
 */

public class BattleController {

    private BattleRenderer renderer;

    private Character[] monsters;
    private Character[] playerCharacters;

    public BattleController(){

        playerCharacters = new Character[]{
                new Outlaw(50, 100, true),
                new Outlaw(50, 50, true)
        };

        monsters = new Character[]{
                new Rat(250, 120, false),
                new Rat(280, 85, false),
                new Rat(250, 50, false)
        };
    }

    public void update(float delta){

    }

    public BattleRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(BattleRenderer renderer) {
        this.renderer = renderer;
    }

    public Character[] getCharacters() {
        Character[] characters = new Character[playerCharacters.length+monsters.length];
        int i;
        for(i=0; i<playerCharacters.length; i++)
            characters[i] = playerCharacters[i];

        for(int j=0; j<monsters.length; j++)
            characters[i++]=monsters[j];
        return characters;
    }
}
