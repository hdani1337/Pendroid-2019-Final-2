package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.cehessteg.donto.Actor.Gomb;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;

public class MenuStage extends MyStage {
    public static AssetList assetList = new AssetList();
    public static final String HATTER_MENU = "menu/hatter_menu.png";
    public static final String GOMB_Z = "other/valasz_zold.png";
    public static final String GOMB_P = "other/valasz_piros.png";
    public static final String GOMB_K = "other/valasz.png";
    public static final String CSANY_LOG = "logos/csany.png";
    public static final String CEHESSTEG_LOG = "logos/cehessteg.png";
    public static final String PENDROID_LOG = "logos/pendroid.png";



    static {
        assetList.addFont(trebuc, trebuc, 120, Color.WHITE, AssetList.CHARS);

        assetList.addTexture(HATTER_MENU);
        assetList.addTexture(GOMB_Z);
        assetList.addTexture(GOMB_P);
        assetList.addTexture(GOMB_K);
        assetList.addTexture(CSANY_LOG);
        assetList.addTexture(CEHESSTEG_LOG);
        assetList.addTexture(PENDROID_LOG);
    }


    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gombZ;
    private OneSpriteStaticActor gombP;
    private OneSpriteStaticActor gombK;
    private OneSpriteStaticActor csany;
    private OneSpriteStaticActor cehessteg;
    private OneSpriteStaticActor pendroid;



    public MenuStage(final MyGame game) {
        super(new ResponseViewport(800), game);
        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                Gdx.app.exit();
            }
        });//HA A MENÜBEN NYOMJUK MEG A VISSZA GOMBOT AKKOR LÉPJEN KI A JÁTÉKBÓL, NE AZ INTRORA LÉPJEN VISSZA
        assignment();//ÉRTÉKEK HOZZÁRENDELÉSE
        addListeners();//LISTENEREK HOZZÁADÁSA
        addActors();//ACTOROK HOZZÁADÁSA A STAGEHEZ
        setPositions();//POZÍCIONÁLGATÁS ÉS ZINDEXELÉS
    }

    void assignment(){
        //Hatter
        background = new OneSpriteStaticActor(game,HATTER_MENU){};

        //Gombok

        gombZ = new OneSpriteStaticActor(game,GOMB_Z);
        gombP = new OneSpriteStaticActor(game,GOMB_P);
        gombK = new OneSpriteStaticActor(game,GOMB_K);

        //Logos

        csany = new OneSpriteStaticActor(game,CSANY_LOG);
        cehessteg = new OneSpriteStaticActor(game,CEHESSTEG_LOG);
        pendroid = new OneSpriteStaticActor(game,PENDROID_LOG);


    }

    void addListeners(){
        //KILÉPÉS LISTENER
        gombP.addListener(new ClickListener(){

            public void clicked(InputEvent event,float x, float y){
                super.clicked(event,x,y);
                Gdx.app.exit();
            }
        });
    }


    void setPositions(){
        //Hatter
        background.setPosition(0,0);

        //Gombok
        gombZ.setSize(gombZ.getWidth()/2,gombZ.getHeight()/2);
        gombZ.setPosition(200,750);

        gombP.setSize(gombP.getWidth()/2,gombP.getHeight()/2);
        gombP.setPosition(200,200);

        gombK.setSize(gombK.getWidth()/2,gombK.getHeight()/2);
        gombK.setPosition(200,475);

        //Logos

        csany.setSize(csany.getWidth()/1.7f,csany.getHeight()/1.7f);
        csany.setPosition(100,50);

    }

    void addActors() {
        addActor(background);
        addActor(gombZ);
        addActor(gombP);
        addActor(gombK);
        addActor(csany);
        addActor(cehessteg);
        addActor(pendroid);

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
        gombZ.setAlpha(alpha);
        gombP.setAlpha(alpha);
        gombK.setAlpha(alpha);
        csany.setAlpha(alpha);
        cehessteg.setAlpha(alpha);
        pendroid.setAlpha(alpha);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fadeIn();//ÁTTŰNÉSSEL JÖNNEK BE A CUCCOK
    }
}
