package com.farguito.sarlanga.battle;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.farguito.sarlanga.actors.Character;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Latharia on 07/12/2016.
 */

public class BattleCharacter {

    private Character character;
    private TextureRegion textureRegion;
    private float turnCounter;

    private boolean isSelected;
    private boolean isPlayerCharacter;
    private boolean turnReady;
    private boolean isAlive;

    private int maxHp;
    private int actualHp;

    private float speed;
    private float actualSpeed;

    private int defense;
    private int actualDefense;

    private int damage;
    private int actualDamage;


    private Vector2 position;

    private Rectangle bounds;

    public BattleCharacter(Character character, int x, int y, boolean isPlayerCharacter){
        this.character = character;
        this.isPlayerCharacter = isPlayerCharacter;
        isAlive = true;
        maxHp = character.getHp();
        actualHp = maxHp;

        speed = character.getSpeed();
        actualSpeed = speed;

        defense = character.getDefense();
        actualDefense = defense;

        damage = character.getDamage();
        actualDamage = damage;

        position = new Vector2(x, y);
        turnCounter = ThreadLocalRandom.current().nextInt(character.getMinTurnCounter(), character.getMaxTurnCounter()+1);
        turnReady = false;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
        bounds = new Rectangle(position.x,
                position.y,
                textureRegion.getRegionWidth(),
                textureRegion.getRegionHeight());
    }

    public Character getCharacter() {
        return character;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public boolean isPlayerCharacter() {
        return isPlayerCharacter;
    }

    public void update() {
    }

    public boolean isTurnReady() {
        return turnReady;
    }

    public void endTurn(){
        turnReady = false;
        turnCounter = 0;
    }

    public float getTurnCounter() {
        return turnCounter;
    }

    public void updateTurn() {
        turnCounter += actualSpeed;
        if(turnCounter >= 100){
            turnReady = true;
        }
    }

    public boolean isTouchDown(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getActualHp() {
        return actualHp;
    }

    public void setActualHp(int actualHp) {
        this.actualHp = actualHp;
    }

    public void takeDamage(int damage){
        actualHp -= damage;
        if(actualHp < 0) {
            actualHp = 0;
        }
    }

    public void setX(float x) {
        position.x = x;
        bounds.setX(x);
    }

    public void setY(float y) {
        position.y = y;
        bounds.setY(y);
    }

    public float getWidth() {
        return getTextureRegion().getRegionWidth();
    }
    public float getHeight() {
        return getTextureRegion().getRegionHeight();
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public float getSpeed() {
        return speed;
    }

    public float getActualSpeed() {
        return actualSpeed;
    }

    public int getDefense() {
        return defense;
    }

    public int getActualDefense() {
        return actualDefense;
    }

    public int getDamage() {
        return damage;
    }

    public int getActualDamage() {
        return actualDamage;
    }


    public void setActualDefense(int actualDefense) {
        this.actualDefense = actualDefense;
    }

    public void setActualSpeed(float actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    public void setActualDamage(int actualDamage) {
        this.actualDamage = actualDamage;
    }
}
