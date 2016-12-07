package com.farguito.sarlanga.actors;

import com.badlogic.gdx.math.Vector2;
import com.farguito.sarlanga.battle.TextureHelper.CharacterCode;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Latharia on 07/12/2016.
 */

public class Character {

    private int hp;
    private int damage;
    private int defense;
    private int speed;
    private int minTurnCounter;
    private int maxTurnCounter;

    private CharacterCode code;

    public Character(int hp, int damage, int defense, int speed, int minTurnCounter, int maxTurnCounter, CharacterCode code) {
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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMinTurnCounter() {
        return minTurnCounter;
    }

    public void setMinTurnCounter(int minTurnCounter) {
        this.minTurnCounter = minTurnCounter;
    }

    public int getMaxTurnCounter() {
        return maxTurnCounter;
    }

    public void setMaxTurnCounter(int maxTurnCounter) {
        this.maxTurnCounter = maxTurnCounter;
    }

    public CharacterCode getCode() {
        return code;
    }
}
