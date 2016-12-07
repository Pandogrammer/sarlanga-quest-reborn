package com.farguito.sarlanga.battle;

import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.actors.Rat;

import java.util.ArrayList;
import java.util.List;

public class BattleController {

    private BattleRenderer renderer;

    private Character[] monsters;
    private Character[] playerCharacters;
    private List<BattleCharacter> battleCharacters;

    public BattleController(){

        playerCharacters = new Character[]{
                new Outlaw(),
                new Outlaw()
        };

        monsters = new Character[]{
                new Rat(),
                new Rat(),
                new Rat()
        };

        battleCharacters = new ArrayList<BattleCharacter>();

        battleCharacters.add(new BattleCharacter(playerCharacters[0], 50, 50, true));
        battleCharacters.add(new BattleCharacter(playerCharacters[1], 50, 100, true));

        switch (monsters.length) {
            case 1:
                battleCharacters.add(new BattleCharacter(monsters[0], 220, 75, false));
                break;
            case 2:
                battleCharacters.add(new BattleCharacter(monsters[0], 220, 50, false));
                battleCharacters.add(new BattleCharacter(monsters[1], 220, 100, false));
                break;
            case 3:
                battleCharacters.add(new BattleCharacter(monsters[0], 220, 35, false));
                battleCharacters.add(new BattleCharacter(monsters[1], 280, 75, false));
                battleCharacters.add(new BattleCharacter(monsters[2], 220, 115, false));
                break;
        }
    }

    public void update(float delta){

    }

    public BattleRenderer getRenderer() {
        return renderer;
    }

    public void setRenderer(BattleRenderer renderer) {
        this.renderer = renderer;
    }

    public List<BattleCharacter> getBattleCharacters() {
        return battleCharacters;
    }
}
