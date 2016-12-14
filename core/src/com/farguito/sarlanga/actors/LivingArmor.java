package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.actors.CharacterCode.LIVING_ARMOR;

public class LivingArmor extends Character {

    private static int hp = 60;
    private static int damage = 13;
    private static int defense = 9;
    private static float speed = 0.7f;
    private static int minTurnCounter = 1;
    private static int maxTurnCounter = 4;

    public LivingArmor() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, LIVING_ARMOR);
    }
}
