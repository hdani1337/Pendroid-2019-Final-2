package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.cehessteg.donto.Actor.Explosion;
import hu.cehessteg.donto.Actor.Vezetek;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;

public class BombStage extends MyStage {

    public static final String BOMBA_TEXTURE = "other/bomba.png";
    public static final String BOMBADEF_TEXTURE = "other/bomb_def.png";
    public static final String DIGITAL = "fonts/digital.ttf";

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(Vezetek.class, assetList);
        assetList.addTexture(BOMBA_TEXTURE);
        assetList.addTexture(BOMBADEF_TEXTURE);
        assetList.addFont(DIGITAL, DIGITAL, 80, Color.WHITE, AssetList.CHARS);
        assetList.addFont(trebuc, trebuc, 80, Color.BLACK, AssetList.CHARS);
    }

    Vezetek piros;
    Vezetek kek;
    Vezetek zold;
    Vezetek sarga;
    Vezetek lila;

    OneSpriteStaticActor bomba;
    OneSpriteStaticActor bombaBG;
    MyLabel clock;
    MyLabel elvagando;

    public BombStage(MyGame game) {
        super(new ResponseViewport(800), game);
        assignment();
        setPositions();
        addActors();
    }

    float sec = 30;

    private void assignment(){
        GameStage.isAct = true;
        bomba = new OneSpriteStaticActor(game, BOMBA_TEXTURE);
        bombaBG = new OneSpriteStaticActor(game, BOMBADEF_TEXTURE);
        piros = new Vezetek(game,"piros");
        kek = new Vezetek(game,"kék");
        zold = new Vezetek(game,"zöld");
        sarga = new Vezetek(game,"sárga");
        lila = new Vezetek(game,"lila");

        addTimer(new TickTimer(0.05f,true,new TickTimerListener(){
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                if(!GameStage.isAct){
                    addActor(new Explosion(game, bomba));
                }
            }
        }));

        clock = new MyLabel(game,"00:30", new Label.LabelStyle(game.getMyAssetManager().getFont(DIGITAL), Color.RED)) {
            @Override
            public void init() {
                setFontScale(2.5f);
            }

            @Override
            public void act(float delta) {
                super.act(delta);
                if(GameStage.isAct) {
                    sec -= delta;
                    if(sec>=10) setText("00:" + (int) sec);
                    else setText("00:0" + (int) sec);
                    if (sec <= 0) GameStage.isAct = false;
                }
            }
        };

        elvagando = new MyLabel(game,"Zöld\n\nSárga\n\nLila", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {
                setAlignment(0);
                setFontScale(0.7f);
                setPosition(getViewport().getWorldWidth()*0.72f, getViewport().getWorldHeight()*0.25f);
            }
        };
    }

    private void setPositions(){
        bomba.setSize(getViewport().getWorldWidth()*0.75f, getViewport().getWorldHeight()*0.9f);
        piros.setPosition(bomba.getX()+60,bomba.getY()+235);
        kek.setPosition(bomba.getX()+160,bomba.getY()+235);
        zold.setPosition(bomba.getX()+260,bomba.getY()+235);
        sarga.setPosition(bomba.getX()+370,bomba.getY()+235);
        lila.setPosition(bomba.getX()+450,bomba.getY()+235);
        clock.setPosition(bomba.getX()+75,bomba.getY()+bomba.getHeight()*0.81f);

        piros.setRotation(-3);
        zold.setRotation(3);
        lila.setRotation(3);
    }

    private void addActors(){
        addActor(bombaBG);
        addActor(bomba);
        addActor(piros);
        addActor(kek);
        addActor(zold);
        addActor(sarga);
        addActor(lila);
        addActor(clock);
        addActor(elvagando);
    }

}
