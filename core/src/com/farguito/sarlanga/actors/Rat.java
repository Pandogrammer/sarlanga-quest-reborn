package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.battle.TextureHelper.CharacterCode.RAT;

public class Rat extends Character {

    public Rat(float x, float y, boolean playerCharacter) {
        super(x, y, 30, 5, 3, 10, 1, 10, RAT, playerCharacter);
    }

}
