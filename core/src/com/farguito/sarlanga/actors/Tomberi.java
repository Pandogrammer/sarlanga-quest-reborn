package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.TOMBERI;

public class Tomberi extends Character {

    private static int hp = 60;
    private static int damage = 40;
    private static int defense = 10;
    private static float speed = 0.25f;
    private static int minTurnCounter = 1;
    private static int maxTurnCounter = 10;

    public Tomberi(){
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, TOMBERI);
    }
}
