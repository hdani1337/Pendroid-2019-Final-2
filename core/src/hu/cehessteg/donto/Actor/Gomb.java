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

import static hu.cehessteg.donto.Stage.GameStage.isAct;
import static hu.cehessteg.donto.Stage.GameStage.isClicked;

public class Gomb extends MyGroup {

    public static String trebuc = "DK Lemon Yellow Sun.otf";
    public static final String GOMB_TEXTURE = "other/valasz.png";
    public static final String GOMB_TEXTURE_GOOD = "other/valasz_zold.png";
    public static final String GOMB_TEXTURE_BAD = "other/valasz_piros.png";

    public static AssetList assetList;

    static {
        assetList = new AssetList();
        assetList.addTexture(GOMB_TEXTURE);
        assetList.addTexture(GOMB_TEXTURE_BAD);
        assetList.addTexture(GOMB_TEXTURE_GOOD);
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
        gombLabel.setTouchable(null);
        gombActor.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (isAct) {
                    if(!isClicked) {
                        if (kerdes.helyesID == gombID) {
                            gombActor.sprite.setTexture(game.getMyAssetManager().getTexture(GOMB_TEXTURE_GOOD));
                        } else {
                            gombActor.sprite.setTexture(game.getMyAssetManager().getTexture(GOMB_TEXTURE_BAD));
                            GameStage.lives--;
                        }
                        //1mp múlva következő kérdés
                        gombActor.addTimer(new TickTimer(1f, false, new TickTimerListener() {
                            @Override
                            public void onTick(Timer sender, float correction) {
                                super.onTick(sender, correction);
                                GameStage.currentID++;
                                isClicked = false;
                            }
                        }));
                        isClicked = true;
                    }
                }
            }
        });
    }

    private void assignment() {
        gombActor = new OneSpriteStaticActor(game, GOMB_TEXTURE);

        gombLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.WHITE)) {
            @Override
            public void init() {
                setAlignment(0);
                setText(text());
            }
        };

        if(kerdes.id == 3){
            switch (text()){
                case "Zöld":{
                    gombActor.setColor(Color.BLUE);
                    break;
                }

                case "Kék":{
                    gombActor.setColor(Color.RED);
                    break;
                }

                case "Lila":{
                    gombActor.setColor(Color.PURPLE);
                    break;
                }

                case "Piros":{
                    gombActor.setColor(Color.GREEN);
                    break;
                }
            }
        }
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
