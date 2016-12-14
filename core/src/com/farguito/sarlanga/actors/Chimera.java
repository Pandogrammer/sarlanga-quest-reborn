package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.actors.CharacterCode.CHIMERA;

public class Chimera extends Character {

    private static int hp = 120;
    private static int damage = 20;
    private static int defense = 10;
    private static float speed = 1f;
    private static int minTurnCounter = 1;
    private static int maxTurnCounter = 10;

    public Chimera() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, CHIMERA);
    }
}
