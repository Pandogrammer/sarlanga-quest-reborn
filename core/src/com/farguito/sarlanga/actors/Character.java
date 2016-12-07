package com.farguito.sarlanga.actors;

import com.badlogic.gdx.math.Vector2;
import com.farguito.sarlanga.battle.TextureHelper.CharacterCode;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Latharia on 07/12/2016.
 */

public class Character {

    private Vector2 position;
    private int width;
    private int height;

    private boolean isAlive;

    private int hp;
    private int damage;
    private int defense;
    private int speed;

    private int turnCounter;

    private boolean playerCharacter;
    private CharacterCode code;

    public Character(float x, float y, int hp, int damage, int defense, int speed, int minTurnCounter, int maxTurnCounter, CharacterCode code, boolean playerCharacter) {
        position = new Vector2(x, y);
        isAlive = true;
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.playerCharacter = playerCharacter;
        this.code = code;
        turnCounter = ThreadLocalRandom.current().nextInt(minTurnCounter, maxTurnCounter + 1);
    }

    public void update(){
        turnCounter += speed;
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

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPlayerCharacter() {
        return playerCharacter;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public CharacterCode getCode() {
        return code;
    }
}
