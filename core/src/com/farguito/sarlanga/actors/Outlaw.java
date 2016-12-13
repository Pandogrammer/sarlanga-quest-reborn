package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.OUTLAW;

public class Outlaw extends Character {

    private static int hp = 40;
    private static int damage = 15;
    private static int defense = 5;
    private static float speed = 1f;
    private static int minTurnCounter = 2;
    private static int maxTurnCounter = 5;

    public Outlaw() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, OUTLAW);
    }

}
