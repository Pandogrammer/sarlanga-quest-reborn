package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.RAT;

public class Rat extends Character {

    private static int hp = 20;
    private static int damage = 10;
    private static int defense = 3;
    private static float speed = 1.5f;
    private static int minTurnCounter = 3;
    private static int maxTurnCounter = 10;

    public Rat() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, RAT);
    }

}
