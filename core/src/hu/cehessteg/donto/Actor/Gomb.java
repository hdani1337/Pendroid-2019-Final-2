package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.cehessteg.donto.Kerdes;
import hu.cehessteg.donto.Stage.GameStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Gomb extends MyGroup {

    public static String trebuc = "DK Lemon Yellow Sun.otf";
    public static final String GOMB_TEXTURE = "other/valasz.png";

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
        /*assignment(buttonType);
        setPositions(buttonType);
        addListener();
        addActors(buttonType);*/
    }

    /*private void addListener(){
        if(gombLabel != null) gombLabel.setTouchable(null);
        if(gombPicture != null) gombPicture.setTouchable(null);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(Kerdes.valaszokList.get(kerdesID).isHelyes(gombID)){
                    //ZÖLD TEXTURE
                }else {
                    //PIROS
                    GameStage.lives--;
                }
                //2mp múlva következő kérdés
                gombActor.addTimer(new TickTimer(2f, false, new TickTimerListener(){
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        GameStage.currentID++;
                    }
                }));
            }
        });
    }

    private void assignment(ButtonType buttonType){
        gombActor = new OneSpriteStaticActor(game, GOMB_TEXTURE);
        switch (buttonType){
            case TEXT:{
                gombLabel = new MyLabel(game,Kerdes.valaszokList.get(kerdesID-1).getValaszok().split(",")[gombID], new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
                    @Override
                    public void init() {
                        setAlignment(0);
                    }
                };
                break;
            }

            case PICTURE:{
                gombPicture = new OneSpriteStaticActor(game, Kerdes.valaszokList.get(kerdesID-1).getValaszok().split(",")[gombID]);
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
    }*/
}
