package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.cehessteg.donto.Actor.Vezetek;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class BombStage extends MyStage {

    public static final String BOMBA_TEXTURE = "other/bomba.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(Vezetek.class, assetList);
        assetList.addTexture(BOMBA_TEXTURE);
    }

    Vezetek piros;
    Vezetek kek;
    Vezetek zold;
    Vezetek sarga;
    Vezetek lila;

    OneSpriteStaticActor bomba;

    public BombStage(MyGame game) {
        super(new ResponseViewport(800), game);
        assignment();
        setPositions();
        addActors();
    }

    private void assignment(){
        bomba = new OneSpriteStaticActor(game, BOMBA_TEXTURE);
        piros = new Vezetek(game,"piros");
        kek = new Vezetek(game,"kék");
        zold = new Vezetek(game,"zöld");
        sarga = new Vezetek(game,"sárga");
        lila = new Vezetek(game,"lila");
    }

    private void setPositions(){
        bomba.setSize(getViewport().getWorldWidth()*0.75f, getViewport().getWorldHeight()*0.9f);
        piros.setPosition(bomba.getX()+60,bomba.getY()+235);
        kek.setPosition(bomba.getX()+160,bomba.getY()+235);
        zold.setPosition(bomba.getX()+260,bomba.getY()+235);
        sarga.setPosition(bomba.getX()+370,bomba.getY()+235);
        lila.setPosition(bomba.getX()+450,bomba.getY()+235);

        piros.setRotation(-3);
        zold.setRotation(3);
        lila.setRotation(3);
    }

    private void addActors(){
        addActor(bomba);
        addActor(piros);
        addActor(kek);
        addActor(zold);
        addActor(sarga);
        addActor(lila);
    }

}
