package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

import hu.cehessteg.donto.Actor.Gomb;
import hu.cehessteg.donto.Kerdes;
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

public class GameStage extends MyStage {

    public static final String BOOK_TEXTURE = "menu/hatter.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(Gomb.class, assetList);
        assetList.addTexture(BOOK_TEXTURE);
        assetList.addFont(trebuc, trebuc, 80, Color.WHITE, AssetList.CHARS);
    }

    //STATIKUS VÁLTOZÓK
    public static boolean isAct;
    public static boolean isClicked;

    private Gomb gombBalF;
    private Gomb gombJobbF;
    private Gomb gombBalA;
    private Gomb gombJobbA;

    private Kerdes kerdes;
    private MyLabel kerdesLabel;

    private MyLabel kerdesSzam;

    public static int currentID;
    public static int lives;

    public static ArrayList<Kerdes> kerdesek;

    private static OneSpriteStaticActor background;

    public GameStage(MyGame game) {
        super(new ResponseViewport(900), game);
        assignment();
        setSizesAndPositions();
        addActors();
    }

    private void assignment()
    {
        isAct = true;
        isClicked = false;

        lives = 3;
        currentID = 14;

        background = new OneSpriteStaticActor(game, BOOK_TEXTURE);

        kerdesek = new ArrayList<>();
        kerdes = new Kerdes(currentID);



        kerdesSzam = new MyLabel(game, kerdes.id + "", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {

            }

            @Override
            public void act(float delta) {
                super.act(delta);
                if (kerdes.id == 14) kerdesSzam.setText("??");
            }
        };

        kerdesLabel = new MyLabel(game, kerdes.kerdes, new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.7f);
                setAlignment(0);
                setPosition(getViewport().getWorldWidth()/2-getWidth()/2,getViewport().getWorldHeight()*0.7f);
            }
        };

        gombBalF = new Gomb(game, kerdes, 1);
        gombBalA = new Gomb(game, kerdes, 3);
        gombJobbF = new Gomb(game, kerdes, 2);
        gombJobbA = new Gomb(game, kerdes, 4);
    }

    private void setSizesAndPositions()
    {
        /**SIZES**/
        background.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        /**POSITIONS**/
        gombBalF.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.4f);
        gombBalA.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.2f);
        gombJobbA.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.4f);
        gombJobbF.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.2f);

        kerdesSzam.setPosition(getViewport().getWorldWidth()-70, getViewport().getWorldHeight()*0.85f);
    }

    private void addActors()
    {
        addActor(background);
        addActor(kerdesLabel);
        addActor(gombBalF);
        addActor(gombBalA);
        addActor(gombJobbA);
        addActor(gombJobbF);
        addActor(kerdesSzam);
    }

    private int prevID;

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isAct) {//Az isAct változó false lesz, ha a játékos veszít vagy megállítja, így ezek nem futnak le feleslegesen
            if(prevID != currentID){
                setStuff();
                third();
                if (currentID == 15) utso();
                prevID = currentID;
            }
            if(lives == 0) isAct = false;
        }
    }

    private void setStuff(){
        isClicked = false;
        kerdes = new Kerdes(currentID);
        kerdesLabel.remove();
        gombBalF.remove();
        gombJobbF.remove();
        gombJobbA.remove();
        gombBalA.remove();
        kerdesLabel = new MyLabel(game, kerdes.kerdes, new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.7f);
                setAlignment(0);
                setPosition(getViewport().getWorldWidth()/2-getWidth()/2,getViewport().getWorldHeight()*0.7f);
            }
        };
        gombBalF = new Gomb(game, kerdes, 1);
        gombBalA = new Gomb(game, kerdes, 3);
        gombJobbF = new Gomb(game, kerdes, 2);
        gombJobbA = new Gomb(game, kerdes, 4);
        kerdesSzam.setText(kerdes.id);
        gombBalF.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.4f);
        gombBalA.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.2f);
        gombJobbA.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.4f);
        gombJobbF.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.2f);
        addActor(kerdesLabel);
        addActor(gombBalF);
        addActor(gombBalA);
        addActor(gombJobbA);
        addActor(gombJobbF);
    }

    private void third(){
        if(kerdes.id == 2){
            kerdesLabel.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    if(x > 600 && x < 680 && y > 0 && y < 50){
                        addTimer(new TickTimer(0, false, new TickTimerListener() {
                            @Override
                            public void onTick(Timer sender, float correction) {
                                super.onTick(sender, correction);
                                currentID++;
                                isClicked = false;
                            }
                        }));
                    }
                }
            });
        }
    }

    private void utso(){
        kerdesSzam.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("bpodsépfksdéfkdslépfvkjysadléf");
                addTimer(new TickTimer(0, false, new TickTimerListener() {
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        currentID++;
                        isClicked = false;
                        }
                }));
            }
        });

    }
}
