package com.farguito.sarlanga.battle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.farguito.sarlanga.battle.BattleController.BattleState.*;

public class TurnHandler {

    private BattleCharacter characterReady;
    private BattleController controller;



    public TurnHandler(BattleController controller){
        this.controller = controller;
    }

    public void update(float delta){
    }

    public void enemyTurn() {
        if(characterReady.isAlive()) {
            int selectedCharacter = ThreadLocalRandom.current().nextInt(0, 2);

            if(!controller.getBattleCharacters().get(selectedCharacter).isAlive())
                selectedCharacter = (selectedCharacter+1)%2;
            controller.setSelectedCharacter(
                    controller.getBattleCharacters().get(selectedCharacter));
            controller.doAttack();
        } else {
            endTurn();
        }
    }

    public void updateRunning() {
        int i = 0;
        while(controller.getCurrentState().equals(RUNNING)
                && i < controller.getBattleCharacters().size()){
            if(controller.getBattleCharacters().get(i).isAlive())
                controller.getBattleCharacters().get(i).updateTurn();

            if(controller.getBattleCharacters().get(i).isTurnReady()) {
                characterReady = controller.getBattleCharacters().get(i);
                if (characterReady.isPlayerCharacter())
                    controller.setCurrentState(PLAYER_TURN);
                else
                    controller.setCurrentState(ENEMY_TURN);
            }
            i++;
        }
    }

    public BattleCharacter getCharacterReady() {
        return characterReady;
    }

    public void endTurn() {
        getCharacterReady().endTurn();
        controller.setCurrentState(CHECK_FINISH);
    }
}
