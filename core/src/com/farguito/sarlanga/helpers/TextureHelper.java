package com.farguito.sarlanga.helpers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farguito.sarlanga.actors.Character;

public class TextureHelper {

    public static TextureRegion getRegion(Character character) {
        switch (character.getCode()){
            case RAT    : return AssetLoader.rat;
            case OUTLAW : return AssetLoader.outlawStanding;
            case TOMBERI : return AssetLoader.tomberi;
            case CHIMERA : return AssetLoader.chimera;
            case YELLOW_IMP : return AssetLoader.yellowImp;
            case PURPLE_BEAST : return AssetLoader.purpleBeast;
        }
        return null;
    }
}
