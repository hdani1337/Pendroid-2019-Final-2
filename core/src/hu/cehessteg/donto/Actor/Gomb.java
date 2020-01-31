package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Gomb extends MyGroup {

    public static String trebuc = "other/trebuc.ttf";
    public static final String GOMB_TEXTURE = "";

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.addTexture(GOMB_TEXTURE);
        assetList.addFont(trebuc, trebuc, 80, Color.WHITE, AssetList.CHARS);
    }

    public OneSpriteStaticActor gombActor;
    public MyLabel gombLabel;

    public Gomb(MyGame game) {
        super(game);
        assignment();
        setPositions();
        addActors();
    }

    private void assignment(){
        gombActor = new OneSpriteStaticActor(game, GOMB_TEXTURE);
        gombLabel = new MyLabel(game,"TEXT", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {
                setAlignment(0);
            }
        };
    }

    private void setPositions(){
        gombActor.setPosition(0,0);
        gombLabel.setPosition(gombActor.getX()+gombActor.getWidth()/2-gombLabel.getWidth()/2, gombActor.getY()+gombActor.getHeight()/2-gombLabel.getHeight()/2);
    }

    private void addActors(){
        addActor(gombActor);
        addActor(gombLabel);
    }
}
