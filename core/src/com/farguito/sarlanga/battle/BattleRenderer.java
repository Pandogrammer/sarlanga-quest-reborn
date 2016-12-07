package com.farguito.sarlanga.battle;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.actors.Character;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;


public class BattleRenderer {

    private int gameHeight;

    private BattleController controller;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private TextureHelper textureHelper;

    private SpriteBatch batcher;

    private Texture buttonBar, selection;
    private TextureRegion background;


    private int midPointY;

    // Game Objects
    private List<BattleCharacter> battleCharacters;

    // Tween stuff
//    private TweenManager manager;
//    private Value alpha = new Value();

    // Buttons
    private List<SimpleButton> menuButtons;
    private SimpleButton attackButton, skillButton, itemButton, defendbutton;

    public BattleRenderer(BattleController controller, int gameHeight, int midPointY) {
        this.controller = controller;
        this.gameHeight = gameHeight;

        this.midPointY = midPointY;

        textureHelper = new TextureHelper();


        cam = new OrthographicCamera();
        cam.setToOrtho(true, SarlangaQuest.GAME_WIDTH, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        battleCharacters = new ArrayList<BattleCharacter>();
        initObjects();
        initAssets();
    }

    private void initObjects(){
        battleCharacters = controller.getBattleCharacters();
    }
    private void initAssets() {
        background = AssetLoader.arena;
        buttonBar = AssetLoader.buttonBar;
        selection = AssetLoader.selection;
        TextureRegion textureRegion;
        for(BattleCharacter battleCharacter : battleCharacters){
            textureRegion = new TextureRegion(textureHelper.getRegion(battleCharacter.getCharacter()));
            if(battleCharacter.isPlayerCharacter()) {
                battleCharacter.setTextureRegion(textureRegion);
            } else {
                textureRegion.flip(true, false);
                battleCharacter.setTextureRegion(textureRegion);
            }
        }
    }

    public void render(float delta, float runTime){

        batcher.begin();
        batcher.disableBlending();

        batcher.draw(background, 0, -buttonBar.getHeight());
        batcher.draw(buttonBar, 0, gameHeight-buttonBar.getHeight());

        batcher.enableBlending();
        for(BattleCharacter battleCharacter : battleCharacters) {
            if(battleCharacter.isAlive()) {
                batcher.draw(
                        battleCharacter.getTextureRegion(),
                        battleCharacter.getX(),
                        battleCharacter.getY());

                if(battleCharacter.isSelected()){
                    batcher.draw(selection,
                            battleCharacter.getBounds().getX()-battleCharacter.getBounds().getWidth()*0.1f,
                            battleCharacter.getBounds().getY()-battleCharacter.getBounds().getHeight()*0.1f,
                            battleCharacter.getBounds().getWidth()*1.15f,
                            battleCharacter.getBounds().getHeight()*1.15f
                            );
                }
            }
        }


        batcher.end();
    }

    public List<BattleCharacter> getBattleCharacters() {
        return battleCharacters;
    }
}
