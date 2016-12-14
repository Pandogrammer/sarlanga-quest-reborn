package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.actors.CharacterCode.TOMBERI;

public class Tomberi extends Character {

    private static int hp = 80;
    private static int damage = 40;
    private static int defense = 7;
    private static float speed = 0.25f;
    private static int minTurnCounter = 0;
    private static int maxTurnCounter = 1;

    public Tomberi(){
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, TOMBERI);
    }
}
