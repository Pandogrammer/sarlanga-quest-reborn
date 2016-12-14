package com.farguito.sarlanga.actors;

public class MonsterFactory {

    public static Character getCharacter(CharacterCode character) {
        switch (character){
            case RAT    : return new Rat();
            case OUTLAW : return new Outlaw();
            case TOMBERI : return new Tomberi();
            case CHIMERA : return new Chimera();
            case YELLOW_IMP : return new YellowImp();
            case PURPLE_BEAST : new PurpleBeast();
            case LIVING_ARMOR : new LivingArmor();
        }
        return null;
    }

}
