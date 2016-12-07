package com.farguito.sarlanga.battle;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.farguito.sarlanga.actors.Character;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Latharia on 07/12/2016.
 */

public class BattleCharacter {

    private Character character;
    private TextureRegion textureRegion;
    private int turnCounter;

    private boolean isSelected;
    private boolean isPlayerCharacter;

    private Vector2 position;

    private Rectangle bounds;

    public BattleCharacter(Character character, int x, int y, boolean isPlayerCharacter){
        this.character = character;
        this.isPlayerCharacter = isPlayerCharacter;
        position = new Vector2(x, y);
        turnCounter = ThreadLocalRandom.current().nextInt(character.getMinTurnCounter(), character.getMaxTurnCounter()+1);
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
        return character.getHp() > 0;
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
}
