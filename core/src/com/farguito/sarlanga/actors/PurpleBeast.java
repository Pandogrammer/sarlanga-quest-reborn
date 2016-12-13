package com.farguito.sarlanga.actors;

import static com.farguito.sarlanga.helpers.TextureHelper.CharacterCode.PURPLE_BEAST;

public class PurpleBeast extends Character {

    private static int hp = 100;
    private static int damage = 20;
    private static int defense = 0;
    private static float speed = 0.5f;
    private static int minTurnCounter = 1;
    private static int maxTurnCounter = 5;

    public PurpleBeast() {
        super(hp, damage, defense, speed, minTurnCounter, maxTurnCounter, PURPLE_BEAST);
    }
}
