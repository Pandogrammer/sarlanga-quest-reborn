package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.actors.CharacterCode.RAT;

public class Rat extends Character {

    private static int hp = 20;
    private static int damage = 15;
    private static int defense = 2;
    private static float speed = 1.5f;
    private static int minTurnCounter = 8;
    private static int maxTurnCounter = 15;

    public Rat() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, RAT);
    }

}
