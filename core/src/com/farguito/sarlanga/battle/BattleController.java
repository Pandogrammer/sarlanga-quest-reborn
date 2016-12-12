package com.farguito.sarlanga.battle;

import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.actors.Outlaw;
import com.farguito.sarlanga.actors.Rat;
import com.farguito.sarlanga.domain.UserConnector;

import java.util.ArrayList;
import java.util.List;

public class BattleController {

    private BattleScreen screen;

    private BattleRenderer renderer;
    private TurnHandler turnHandler;

    private Character[] monsters;
    private Character[] playerCharacters;
    private List<BattleCharacter> battleCharacters;

    private BattleState currentState;

    private BattleCharacter selectedCharacter;

    public void doAttack() {
        attack(turnHandler.getCharacterReady(), selectedCharacter);
    }
    public void endTurn(){
        turnHandler.endTurn();
        selectedCharacter = null;

    }
    private void attack(BattleCharacter attacker, BattleCharacter defender) {
        currentState = BattleState.ATTACKING;
        renderer.drawAttack(attacker, defender);
    }


    public int applyDamage(BattleCharacter attacker, BattleCharacter defender){
        int damage = attacker.getCharacter().getDamage() - defender.getCharacter().getDefense();
        defender.takeDamage(damage);
        if(defender.getActualHp() == 0){
            defender.setAlive(false);
        }
        return damage;
    }

    public void setSelectedCharacter(BattleCharacter selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public BattleCharacter getSelectedCharacter() {
        return selectedCharacter;
    }

    public boolean isAttacking() {
        return currentState.equals(BattleState.ATTACKING);
    }

    public boolean battleHasEnded() {
        return currentState.equals(BattleState.DEFEAT) || currentState.equals(BattleState.VICTORY);
    }

    public void goMenu() {
        screen.goMenu();
    }

    private void initSelectedCharacters() {
        UserConnector conn = new UserConnector();
        playerCharacters = conn.getSelectedCharacters();
    }
    private void initEnemyCharacters(){
        monsters = new Character[]{
                new Rat()
//                ,
//                new Rat(),
//                new Rat()
        };
    }


    public enum BattleState {
        PLAYER_TURN, ENEMY_TURN, RUNNING, DEFEAT, VICTORY, CHECK_FINISH, ATTACKING
    }

    public BattleController(BattleScreen screen){
        this.screen = screen;
        currentState = BattleState.RUNNING;
        turnHandler = new TurnHandler(this);
        initCharacters();
    }

    private void initCharacters() {

        initSelectedCharacters();
        initEnemyCharacters();


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
        switch (currentState) {
            case CHECK_FINISH:
                checkFinish();
            case RUNNING:
                turnHandler.updateRunning();
                break;
            case ENEMY_TURN:
                turnHandler.enemyTurn();
                break;
            default:
        }
    }

    private void checkFinish() {
        boolean defeat = true;
        boolean victory = true;
        for (BattleCharacter battleCharacter : battleCharacters) {
            if (battleCharacter.isPlayerCharacter()) {
                if (battleCharacter.isAlive())
                    defeat = false;
            } else {
                if (battleCharacter.isAlive())
                    victory = false;
            }
        }

        if (defeat) {
            currentState = BattleState.DEFEAT;
            renderer.prepareEndMessage(false);
        } else if (victory) {
            currentState = BattleState.VICTORY;
            renderer.prepareEndMessage(true);
        } else {
            currentState = BattleState.RUNNING;
        }
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

    public BattleState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(BattleState currentState) {
        this.currentState = currentState;
    }

    public boolean isPlayerTurn() {
        return currentState.equals(BattleState.PLAYER_TURN);
    }

}
