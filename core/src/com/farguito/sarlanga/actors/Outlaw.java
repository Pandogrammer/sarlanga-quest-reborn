package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.battle.TextureHelper.CharacterCode.OUTLAW;

public class Outlaw extends Character {

    public Outlaw(float x, float y, boolean playerCharacter) {
        super(x, y, 100, 10, 5, 10, 3, 10, OUTLAW, playerCharacter);
    }

}