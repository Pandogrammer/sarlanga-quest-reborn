package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.CHIMERA;

public class Chimera extends Character {

    private static int hp = 140;
    private static int damage = 20;
    private static int defense = 5;
    private static float speed = 1f;
    private static int minTurnCounter = 8;
    private static int maxTurnCounter = 15;

    public Chimera() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, CHIMERA);
    }
}
