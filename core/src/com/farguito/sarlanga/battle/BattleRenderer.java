package com.farguito.sarlanga.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.farguito.sarlanga.SarlangaQuest;
import com.farguito.sarlanga.helpers.AssetLoader;
import com.farguito.sarlanga.tween.BattleCharacterAccessor;
import com.farguito.sarlanga.tween.SpriteAccessor;
import com.farguito.sarlanga.ui.SimpleButton;

import java.util.ArrayList;
import java.util.List;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import static com.farguito.sarlanga.tween.BattleCharacterAccessor.POSITION;


public class BattleRenderer {

    private int gameHeight;
    private float keyFrame;

    private BattleController controller;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private TextureHelper textureHelper;

    private SpriteBatch batcher;

    private Texture selection;
    private TextureRegion background, turnBar, turnIndicator, buttonBar;
    private TextureRegion[] turnArrows;
    private Animation attack;

    private BitmapFont text;
    private int damageDone;

    private int midPointY;

    // Game Objects
    private List<BattleCharacter> battleCharacters;

    // Tween stuff
    private TweenManager manager;

    // Buttons
    private List<SimpleButton> menuButtons;
    private boolean drawAttackAnimation;

    public BattleRenderer(BattleController controller, int gameHeight, int midPointY) {
        this.controller = controller;
        this.gameHeight = gameHeight;

        this.midPointY = midPointY;
        this.menuButtons = ((BattleInputHandler) Gdx.input.getInputProcessor())
                .getMenuButtons();
        textureHelper = new TextureHelper();


        cam = new OrthographicCamera();
        cam.setToOrtho(true, SarlangaQuest.GAME_WIDTH, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        battleCharacters = new ArrayList<BattleCharacter>();
        drawAttackAnimation = false;
        initObjects();
        initAssets();

        Tween.registerAccessor(BattleCharacter.class, new BattleCharacterAccessor());
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        manager = new TweenManager();
    }

    private void initObjects(){
        battleCharacters = controller.getBattleCharacters();
    }
    private void initAssets() {
        background = AssetLoader.arena;
        buttonBar = AssetLoader.buttonBar;
        turnBar = AssetLoader.turnBar;
        turnArrows = new TextureRegion[]{
                AssetLoader.turnP1,
                AssetLoader.turnP2,
                AssetLoader.turnE1,
                AssetLoader.turnE2,
                AssetLoader.turnE3
        };
        turnIndicator = AssetLoader.turnIndicator;
        selection = AssetLoader.selection;
        attack = AssetLoader.attackAnimation;
        text = AssetLoader.text;

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

        batcher.draw(background, 0, 0);

        drawButtonBar();

        batcher.enableBlending();
        batcher.draw(turnBar, 20, 30);

        drawCharacters();

        manager.update(delta);

        if(drawAttackAnimation){
            keyFrame += delta;
            batcher.draw(attack.getKeyFrame(keyFrame),
                    controller.getSelectedCharacter().getX(),
                    controller.getSelectedCharacter().getY(),
                    controller.getSelectedCharacter().getWidth(),
                    controller.getSelectedCharacter().getHeight());

            text.draw(batcher,
                    ""+damageDone,
                    controller.getSelectedCharacter().getX()+controller.getSelectedCharacter().getWidth()/2,
                    controller.getSelectedCharacter().getY()- 30);
        }

        batcher.end();
    }

    private void drawButtonBar() {
        for (SimpleButton button : menuButtons) {
            button.draw(batcher);
        }

    }

    private void drawCharacters() {
        for(int i = 0; i < battleCharacters.size(); i++) {
            if(battleCharacters.get(i).isAlive()) {
                batcher.draw(
                        battleCharacters.get(i).getTextureRegion(),
                        battleCharacters.get(i).getX(),
                        battleCharacters.get(i).getY());

                if(controller.getSelectedCharacter() != null && controller.getSelectedCharacter().isAlive()){
                    batcher.draw(selection,
                            controller.getSelectedCharacter().getBounds().getX()-controller.getSelectedCharacter().getBounds().getWidth()*0.1f,
                            controller.getSelectedCharacter().getBounds().getY()-controller.getSelectedCharacter().getBounds().getHeight()*0.1f,
                            controller.getSelectedCharacter().getBounds().getWidth()*1.15f,
                            controller.getSelectedCharacter().getBounds().getHeight()*1.15f
                    );
                }
                if(i < 2) {
                    //es aliado
                    batcher.draw(turnArrows[i], 21-turnArrows[i].getRegionWidth(),
                            21 + turnBar.getRegionHeight() - battleCharacters.get(i).getTurnCounter());
                } else {
                    //sino es enemigo
                    batcher.draw(turnArrows[i], 19+turnBar.getRegionWidth(),
                            21 + turnBar.getRegionHeight() - battleCharacters.get(i).getTurnCounter());
                }
            }
            if(battleCharacters.get(i).isTurnReady() && battleCharacters.get(i).isPlayerCharacter() && controller.isPlayerTurn()){
                batcher.draw(turnIndicator,
                        battleCharacters.get(i).getBounds().getX() + battleCharacters.get(i).getBounds().getWidth() + 5,
                        battleCharacters.get(i).getBounds().getY() + battleCharacters.get(i).getBounds().getHeight() / 2);
            }

        }
    }

    public List<BattleCharacter> getBattleCharacters() {
        return battleCharacters;
    }


    public void drawAttack(final BattleCharacter attacker, final BattleCharacter defender) {


        Timeline.createSequence()
                .push(Tween.to(attacker, POSITION, 0.8f)
                        .target(defender.isPlayerCharacter() ?
                                        defender.getX()+defender.getWidth() : defender.getX()-defender.getWidth()
                                , defender.getY())
                        .setCallback(new TweenCallback() {
                            @Override
                            public void onEvent(int type, BaseTween<?> source) {
                                keyFrame = 0;
                                damageDone = controller.applyDamage(attacker, defender);
                                drawAttackAnimation = true;
                            }
                        }))
                .push(Tween.to(attacker, POSITION, 0.4f)
                           .target(attacker.getX(), attacker.getY())
                           .delay(attack.getAnimationDuration()))
                .setCallback(new TweenCallback() {
                    @Override
                    public void onEvent(int type, BaseTween<?> source) {
                        drawAttackAnimation = false;
                        controller.endTurn();
                    }
                })
                .start(manager);
    }

}
