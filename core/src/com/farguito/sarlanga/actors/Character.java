package com.farguito.sarlanga.actors;

public class Character {

    private int hp;
    private int damage;
    private int defense;
    private float speed;
    private int minTurnCounter;
    private int maxTurnCounter;

    private CharacterCode code;

    public Character(int hp, int damage, int defense, float speed, int minTurnCounter, int maxTurnCounter, CharacterCode code) {
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.code = code;
        this.minTurnCounter = minTurnCounter;
        this.maxTurnCounter = maxTurnCounter;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public float getSpeed() {
        return speed;
    }

    public int getMinTurnCounter() {
        return minTurnCounter;
    }

    public int getMaxTurnCounter() {
        return maxTurnCounter;
    }

    public CharacterCode getCode() {
        return code;
    }
}
