package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.YELLOW_IMP;

public class YellowImp extends Character {

    private static int hp = 40;
    private static int damage = 10;
    private static int defense = 5;
    private static float speed = 2f;
    private static int minTurnCounter = 5;
    private static int maxTurnCounter = 10;

    public YellowImp() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, YELLOW_IMP);
    }
}
