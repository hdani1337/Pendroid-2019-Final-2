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
    public int gombID;
    private Kerdes kerdes;

    public Gomb(MyGame game, Kerdes kerdes, int id) {
        super(game);
        this.gombID = id;
        this.kerdes = kerdes;
        assignment();
        setPositions();
        addListener();
        addActors();
    }

    private void addListener() {
        if (gombLabel != null) gombLabel.setTouchable(null);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(kerdes.helyesID == gombID){
                    //ZÖLD TEXTURE
                }else {
                    //PIROS
                    GameStage.lives--;
                }
                //2mp múlva következő kérdés
                gombActor.addTimer(new TickTimer(2f, false, new TickTimerListener() {
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        GameStage.currentID++;
                    }
                }));
            }
        });
    }

    private void assignment() {
        gombActor = new OneSpriteStaticActor(game, GOMB_TEXTURE);

        gombLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {
                setAlignment(0);
                setText(text());
            }
        };
    }

    private String text(){
        switch (gombID){
            case 1:{
                return kerdes.valasz1;
            }

            case 2:{
                return kerdes.valasz2;
            }

            case 3:{
                return kerdes.valasz3;
            }

            case 4:{
                return kerdes.valasz4;
            }

            default: return "";
        }
    }

    private void setPositions() {
        gombActor.setSize(gombActor.getWidth()/2,gombActor.getHeight()/2);
        gombLabel.setFontScale(0.5f);
        gombActor.setPosition(0, 0);
        gombLabel.setPosition(gombActor.getX() + gombActor.getWidth() / 2 - gombLabel.getWidth() / 2, gombActor.getY() + gombActor.getHeight() / 2 - gombLabel.getHeight() / 2);
    }

    private void addActors() {
        addActor(gombActor);
        addActor(gombLabel);
    }
}
