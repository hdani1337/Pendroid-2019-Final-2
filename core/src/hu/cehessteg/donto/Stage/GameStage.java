package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import java.util.ArrayList;

import hu.cehessteg.donto.Actor.Gomb;
import hu.cehessteg.donto.Kerdes;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;

public class GameStage extends MyStage {

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(Gomb.class, assetList);
        assetList.addFont(trebuc, trebuc, 80, Color.WHITE, AssetList.CHARS);
    }

    private Kerdes kerdesClass = new Kerdes(1);

    //STATIKUS VÁLTOZÓK
    public static boolean isAct;
    public static boolean isDead;

    private Gomb gombBalF;
    private Gomb gombJobbF;
    private Gomb gombBalA;
    private Gomb gombJobbA;

    private Kerdes kerdes;
    private MyLabel kerdesLabel;

    public static int currentID;
    public static int lives;

    public static ArrayList<Kerdes> kerdesek;

    public GameStage(MyGame game) {
        super(new ResponseViewport(900), game);
        assignment();
        setSizesAndPositions();
        addActors();
    }

    private void assignment()
    {
        isAct = true;
        isDead = false;

        lives = 3;
        currentID = 1;

        kerdesek = new ArrayList<>();
        kerdes = new Kerdes(currentID);

        kerdesLabel = new MyLabel(game, kerdes.kerdes, new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.WHITE)) {
            @Override
            public void init() {
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

        /**POSITIONS**/
        gombBalF.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.5f);
        gombBalA.setPosition(getViewport().getWorldWidth()/2-375, getViewport().getWorldHeight()*0.2f);
        gombJobbA.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.5f);
        gombJobbF.setPosition(getViewport().getWorldWidth()/2+30, getViewport().getWorldHeight()*0.2f);
    }

    private void addActors()
    {
        addActor(kerdesLabel);
        addActor(gombBalF);
        addActor(gombBalA);
        addActor(gombJobbA);
        addActor(gombJobbF);
    }

    private int prevID;

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isAct) {//Az isAct változó false lesz, ha a játékos veszít vagy megállítja, így ezek nem futnak le feleslegesen
            if(prevID != currentID){
                kerdes = new Kerdes(currentID);
                gombBalF = new Gomb(game, kerdes, 1);
                gombBalA = new Gomb(game, kerdes, 3);
                gombJobbF = new Gomb(game, kerdes, 2);
                gombJobbA = new Gomb(game, kerdes, 4);
            }
        }
        else{
        }
    }
}
