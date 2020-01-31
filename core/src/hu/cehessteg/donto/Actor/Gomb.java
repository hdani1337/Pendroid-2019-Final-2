package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.cehessteg.donto.Kerdes;
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
    public OneSpriteStaticActor gombPicture;
    public int gombID;
    public int kerdesID;

    public enum ButtonType{
        TEXT, PICTURE
    }

    public Gomb(MyGame game, ButtonType buttonType, int id, int kerdesID) {
        super(game);
        this.gombID = id;
        this.kerdesID = kerdesID;
        assignment(buttonType);
        setPositions(buttonType);
        addActors(buttonType);
    }

    private void assignment(ButtonType buttonType){
        gombActor = new OneSpriteStaticActor(game, GOMB_TEXTURE);
        switch (buttonType){
            case TEXT:{
                gombLabel = new MyLabel(game,Kerdes.valaszokList.get(kerdesID).getValaszok().split(",")[gombID], new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
                    @Override
                    public void init() {
                        setAlignment(0);
                    }
                };
                break;
            }

            case PICTURE:{
                gombPicture = new OneSpriteStaticActor(game, Kerdes.valaszokList.get(kerdesID).getValaszok().split(",")[gombID]);
                break;
            }
        }
    }

    private void setPositions(ButtonType buttonType){
        gombActor.setPosition(0,0);
        switch (buttonType){
            case PICTURE:{
                gombPicture.setPosition(gombActor.getX()+gombActor.getWidth()/2-gombPicture.getWidth()/2, gombActor.getY()+gombActor.getHeight()/2-gombPicture.getHeight()/2);
            }

            case TEXT:{
                gombLabel.setPosition(gombActor.getX()+gombActor.getWidth()/2-gombLabel.getWidth()/2, gombActor.getY()+gombActor.getHeight()/2-gombLabel.getHeight()/2);
                break;
            }
        }
    }

    private void addActors(ButtonType buttonType){
        addActor(gombActor);
        switch (buttonType){
            case PICTURE:{
                addActor(gombPicture);
            }

            case TEXT:{
                addActor(gombLabel);
                break;
            }
        }
    }
}
