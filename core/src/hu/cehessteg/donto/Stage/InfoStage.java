package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;
import static hu.cehessteg.donto.Stage.GameOverStage.BLANK_TEXTURE;

public class InfoStage extends MyStage {
    public static String trebuc = "fonts/handbold.otf";
    public static String trebuc2 = "fonts/hand.otf";
    public static final String ZOLI_KEP = "portraits/zoli.png";
    public static final String BENCE_KEP = "portraits/bence.png";
    public static final String DANI_KEP = "portraits/dani.png";
    public static final String DAVID_KEP = "portraits/david.png";
    public static final String HATTER_BG = "menu/hatter.png";
    public static AssetList assetList = new AssetList();

    static {
        assetList.addTexture(ZOLI_KEP);
        assetList.addTexture(BENCE_KEP);                //Ujra kell majd csinalni a pozíciokat!
        assetList.addTexture(DANI_KEP);
        assetList.addTexture(DAVID_KEP);
        assetList.addTexture(BLANK_TEXTURE);
        assetList.addTexture(HATTER_BG);
        assetList.addFont(trebuc, trebuc, 120, Color.WHITE, AssetList.CHARS);
        assetList.addFont(trebuc2, trebuc2, 120, Color.WHITE, AssetList.CHARS);
    }

    //-----KÉPEK-----
    private OneSpriteStaticActor zoli;
    private OneSpriteStaticActor bence;
    private OneSpriteStaticActor dani;
    private OneSpriteStaticActor david;
    private OneSpriteStaticActor hatter;
    //---------------

    //-----NEVEK-----
    private MyLabel zoliLabel;
    private MyLabel benceLabel;
    private MyLabel daniLabel;
    private MyLabel davidLabel;
    //---------------

    //-----BEOSZTÁS-----
    private MyLabel zoliLabelTitle;
    private MyLabel benceLabelTitle;
    private MyLabel daniLabelTitle;
    private MyLabel davidLabelTitle;
    //------------------

    //LEÍRÁS
    private MyLabel infoText;
    private MyLabel informacio;
    private MyLabel informacio2;

    //-----HÁTTÉR-----
    private OneSpriteStaticActor black;
    //----------------

    //VISSZA ÉS HÁTTERE

    public InfoStage(MyGame game) {
        super(new ResponseViewport(800),game);
        assignment();
        labelStuff();
        setPositions();
        addActors();
    }

    void assignment()
    {
        pictures();//KÉPEK
        names();//NEVEK
        titles();//TITULUSOK

        infoText = new MyLabel(game, "Info", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {

            }
        };

        informacio = new MyLabel(game, "Játék leírás:", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {


            }
        };
        informacio2 = new MyLabel(game, "A játék quiz-szerüen van kialakítva, kérdésekre\n\nkell válaszolni, illetve van egy-egy mini-game is!", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {


            }
        };


    }

    void pictures()
    {
        zoli = new OneSpriteStaticActor(game,ZOLI_KEP);
        bence = new OneSpriteStaticActor(game,BENCE_KEP);
        dani = new OneSpriteStaticActor(game,DANI_KEP);
        david = new OneSpriteStaticActor(game,DAVID_KEP);
        hatter = new OneSpriteStaticActor(game,HATTER_BG);
    }

    void names()
    {
        zoliLabel = new MyLabel(game, "Miklós Zoltán", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {


            }
        };
        benceLabel = new MyLabel(game, "Kutai Bence", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {

            }
        };
        daniLabel = new MyLabel(game, "Horváth Dániel", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {

            }
        };
        davidLabel = new MyLabel(game, "Halász Dávid", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {
            }
        };
    }

    void titles()
    {
        zoliLabelTitle = new MyLabel(game, "Programozó", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.4f);
            }
        };
        benceLabelTitle = new MyLabel(game, "Grafikus", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.4f);
            }
        };
        daniLabelTitle = new MyLabel(game, "Programozó", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.4f);
            }
        };
        davidLabelTitle = new MyLabel(game, "Programozó", new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.BLACK)) {
            @Override
            public void init() {
                setFontScale(0.4f);
            }
        };
    }



    void labelStuff()
    {
        informacio.setFontScale(0.5f);
        informacio2.setFontScale(0.5f);

        zoliLabel.setFontScale(0.5f);
        benceLabel.setFontScale(0.5f);
        daniLabel.setFontScale(0.5f);
        davidLabel.setFontScale(0.5f);


        zoliLabelTitle.setFontScale(0.5f);
        benceLabelTitle.setFontScale(0.5f);
        daniLabelTitle.setFontScale(0.5f);
        davidLabelTitle.setFontScale(0.5f);


        zoliLabel.setAlignment(0);
        benceLabel.setAlignment(0);
        daniLabel.setAlignment(0);
        davidLabel.setAlignment(0);

        zoliLabelTitle.setAlignment(0);
        benceLabelTitle.setAlignment(0);
        daniLabelTitle.setAlignment(0);
        davidLabelTitle.setAlignment(0);

        infoText.setAlignment(0);
    }

    void setPositions()
    {
        //HATTER//
       hatter.setPosition(0,0);
        //CÍM,MAS//
       infoText.setPosition(350,950);
       informacio.setPosition(100,170);
       informacio2.setPosition(100,20);

       //KEPEK//

        zoli.setPosition(100,750);
        bence.setPosition(550,750);
        dani.setPosition(100,400);
        david.setPosition(550,400);

        //NEVEK//

        zoliLabel.setPosition(30,695);
        benceLabel.setPosition(530,695);
        daniLabel.setPosition(30,335);
        davidLabel.setPosition(500,335);

        //TITULUSOK//

        zoliLabelTitle.setPosition(60,650);
        benceLabelTitle.setPosition(570,650);
        daniLabelTitle.setPosition(60,280);
        davidLabelTitle.setPosition(510,280);


    }

    void addActors()
    {
        addActor(hatter);

        addActor(zoli);
        addActor(bence);
        addActor(dani);
        addActor(david);

        addActor(zoliLabel);
        addActor(benceLabel);
        addActor(daniLabel);
        addActor(davidLabel);

        addActor(zoliLabelTitle);
        addActor(benceLabelTitle);
        addActor(daniLabelTitle);
        addActor(davidLabelTitle);

        addActor(infoText);
        addActor(informacio);
        addActor(informacio2);




    }


    float alpha = 0;

    void fadeIn()
    {
        if(alpha < 0.98) {
            alpha += 0.02;
            setAlphas();
        }
        else alpha = 1;

    }

    void setAlphas()
    {
        zoli.setAlpha(alpha);
        bence.setAlpha(alpha);
        dani.setAlpha(alpha);
        david.setAlpha(alpha);


        zoliLabel.setColor(1,1,1, alpha);
        benceLabel.setColor(1,1,1, alpha);
        daniLabel.setColor(1,1,1, alpha);
        davidLabel.setColor(1,1,1, alpha);

        zoliLabelTitle.setColor(1,1,1, alpha);
        benceLabelTitle.setColor(1,1,1, alpha);
        daniLabelTitle.setColor(1,1,1, alpha);
        davidLabelTitle.setColor(1,1,1, alpha);

        infoText.setColor(1,1,1, alpha);
        informacio.setColor(1,1,1,alpha);
        informacio2.setColor(1,1,1,alpha);


       hatter.setAlpha(alpha);
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        fadeIn();

        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)){
            /**
             * !!!NEM MŰKÖDIK A addBackButtonScreenBackByStackPopListener()!!!
             * **/
            game.setScreenBackByStackPop();
        }
    }
}