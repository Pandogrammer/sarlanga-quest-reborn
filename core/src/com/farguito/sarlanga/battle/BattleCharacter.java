package com.farguito.sarlanga.battle;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farguito.sarlanga.actors.Character;

/**
 * Created by Latharia on 07/12/2016.
 */

public class BattleCharacter {

    private Character character;
    private TextureRegion textureRegion;

    public BattleCharacter(Character character){
        this.character = character;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
