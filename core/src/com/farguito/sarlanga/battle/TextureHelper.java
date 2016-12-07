package com.farguito.sarlanga.battle;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.helpers.AssetLoader;

public class TextureHelper {

    public enum CharacterCode {
        RAT, OUTLAW
    }

    public TextureRegion getRegion(Character character) {
        switch (character.getCode()){
            case RAT    : return AssetLoader.rat;
            case OUTLAW : return AssetLoader.outlawStanding;
        }
        return null;
    }
}
