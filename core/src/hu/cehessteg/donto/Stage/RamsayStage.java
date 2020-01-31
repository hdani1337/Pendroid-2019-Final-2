package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.cehessteg.donto.Actor.Ramsay;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;

public class RamsayStage extends MyStage {

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.collectAssetDescriptor(Ramsay.class, assetList);
        assetList.addFont(trebuc, trebuc, 80, Color.WHITE, AssetList.CHARS);
    }

    private MyLabel text;
    private Ramsay ramsay;

    public RamsayStage(MyGame game) {
        super(new ResponseViewport(800), game);
        assignment();
        setPositions();
        addActors();
    }

    private void assignment(){
        ramsay = new Ramsay(game);
        text = new MyLabel(game,"Idegesítsd fel Ramsay-t!\n(kattints rá többször)", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.WHITE)) {
            @Override
            public void init() {
                setAlignment(0);
                setFontScale(0.7f);
            }
        };
    }

    private void setPositions(){
        text.setPosition(getViewport().getWorldWidth()/2-text.getWidth()/2,getViewport().getWorldHeight()/2-text.getHeight()/2);
    }

    private void addActors(){
        addActor(ramsay);
        addActor(text);
    }
}
