package com.farguito.sarlanga.tween;

import com.farguito.sarlanga.battle.BattleCharacter;

import aurelienribon.tweenengine.TweenAccessor;

public class BattleCharacterAccessor implements TweenAccessor<BattleCharacter> {

    public static final int POSITION = 1;

    @Override
    public int getValues(BattleCharacter target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITION:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            default:
                return 0;
        }
    }

    @Override
    public void setValues(BattleCharacter target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POSITION:
                target.setX(newValues[0]);
                target.setY(newValues[1]);
                break;
        }
    }
}
