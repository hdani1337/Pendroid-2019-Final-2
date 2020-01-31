package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.cehessteg.donto.Screen.GameScreen;
import hu.cehessteg.donto.Stage.GameStage;
import hu.cehessteg.donto.Stage.MyPreLoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class Ramsay extends OneSpriteStaticActor {

    public static final String RAMSAY_1 = "ramsay/ramsay1.png";
    public static final String RAMSAY_2 = "ramsay/ramsay2.png";
    public static final String RAMSAY_3 = "ramsay/ramsay3.png";
    public static final String RAMSAY_4 = "ramsay/ramsay4.png";
    public static final String RAMSAY_5 = "ramsay/ramsay5.png";

    public static final String RAMSAY_2S = "ramsay/Ramsay_1.mp3";
    public static final String RAMSAY_3S = "ramsay/Ramsay_2.mp3";
    public static final String RAMSAY_4S = "ramsay/Ramsay_3.mp3";
    public static final String RAMSAY_5S = "ramsay/Ramsay_4.mp3";

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.addTexture(RAMSAY_1);
        assetList.addTexture(RAMSAY_2);
        assetList.addTexture(RAMSAY_3);
        assetList.addTexture(RAMSAY_4);
        assetList.addTexture(RAMSAY_5);

        assetList.addSound(RAMSAY_2S);
        assetList.addSound(RAMSAY_3S);
        assetList.addSound(RAMSAY_4S);
        assetList.addSound(RAMSAY_5S);
    }

    public byte rage = 0;

    public Ramsay(MyGame game) {
        super(game, RAMSAY_1);
        addListeners();
    }

    private void addListeners(){
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                rage++;
                if(rage >= 40) {
                    addTimer(new TickTimer(2, true, new TickTimerListener() {
                        @Override
                        public void onTick(Timer sender, float correction) {
                            super.onTick(sender, correction);
                            GameStage.currentID = 14;
                            game.setScreenWithPreloadAssets(GameScreen.class, new MyPreLoadingStage(game));
                        }

                    }));
                    game.getMyAssetManager().getSound(RAMSAY_5S).play();
                }
                else if(rage >= 30) {
                    game.getMyAssetManager().getSound(RAMSAY_4S).play();
                }
                else if (rage >= 20) {
                    game.getMyAssetManager().getSound(RAMSAY_3S).play();
                }
                else if (rage >= 10) {
                    game.getMyAssetManager().getSound(RAMSAY_2S).play();
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(rage >= 40) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_5))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_5));
        }
        if(rage >= 30) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_4))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_4));
        }
        else if (rage >= 20) {
                if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_3))
                    sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_3));
            }
        else if (rage >= 10) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_2))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_2));
        }
        else if (rage >= 0) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_1))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_1));
        }
    }
}
