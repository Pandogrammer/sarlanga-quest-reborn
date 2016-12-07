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

    private BattleController controller;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private TextureHelper textureHelper;

    private SpriteBatch batcher;

    private Texture background, buttonBar;


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

        this.midPointY = midPointY;

        textureHelper = new TextureHelper();


        cam = new OrthographicCamera();
        cam.setToOrtho(false, SarlangaQuest.GAME_WIDTH, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        battleCharacters = new ArrayList<BattleCharacter>();
        initObjects();
        initAssets();
    }

    private void initObjects(){
        for(Character character : controller.getCharacters()){
            battleCharacters.add(new BattleCharacter(character));
        }
    }
    private void initAssets() {
        background = AssetLoader.arena;
        buttonBar = AssetLoader.buttonBar;
        TextureRegion textureRegion;
        Character character;
        for(BattleCharacter battleCharacter : battleCharacters){
            character = battleCharacter.getCharacter();
            textureRegion = textureHelper.getRegion(character);
            if(character.isPlayerCharacter()) {
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

        batcher.draw(background, 0, buttonBar.getHeight());
        batcher.draw(buttonBar, 0, 0);

        batcher.enableBlending();
        for(BattleCharacter battleCharacter : battleCharacters) {
            if(battleCharacter.getCharacter().isAlive())
                batcher.draw(
                        battleCharacter.getTextureRegion(),
                        battleCharacter.getCharacter().getPosition().x,
                        battleCharacter.getCharacter().getPosition().y);
        }

        batcher.end();
    }
}
