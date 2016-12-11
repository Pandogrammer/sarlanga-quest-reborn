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
        switch (controller.getCurrentState()) {
            case RUNNING:
                updateRunning();
                break;
            case PLAYER_TURN:
                break;
            case ENEMY_TURN:
                if(characterReady.isAlive()) {
                    controller.setSelectedCharacter(controller.getBattleCharacters().get(
                            ThreadLocalRandom.current().nextInt(0, 2)));
                    controller.doAttack();
                } else {
                    characterReady.endTurn();
                    controller.setCurrentState(RUNNING);
                }
                break;
        }

    }

    private void updateRunning() {
        int i = 0;
        while(controller.getCurrentState().equals(RUNNING)
                && i < controller.getBattleCharacters().size()){
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
        controller.setCurrentState(RUNNING);
    }
}
