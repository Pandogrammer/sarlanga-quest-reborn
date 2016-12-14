package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.actors.CharacterCode.OUTLAW;

public class Outlaw extends Character {

    private static int hp = 60;
    private static int damage = 15;
    private static int defense = 6;
    private static float speed = 1f;
    private static int minTurnCounter = 2;
    private static int maxTurnCounter = 7;

    public Outlaw() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, OUTLAW);
    }

}
