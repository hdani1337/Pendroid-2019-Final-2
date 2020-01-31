package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.cehessteg.donto.Screen.GameScreen;
import hu.cehessteg.donto.Screen.InfoScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static hu.cehessteg.donto.Actor.Gomb.trebuc;

public class MenuStage extends MyStage {
    public static AssetList assetList = new AssetList();
    public static String trebuc = "fonts/handbold.otf";
    public static String  trebuc2 = "fonts/hand.otf";
    public static final String HATTER_MENU = "menu/hatter_menu.png";
    public static final String GOMB_Z = "other/valasz_zold.png";
    public static final String GOMB_P = "other/valasz_piros.png";
    public static final String GOMB_K = "other/valasz.png";




    static {
        assetList.addFont(trebuc, trebuc, 120, Color.BLACK, AssetList.CHARS);
        assetList.addFont(trebuc2, trebuc2, 80, Color.WHITE, AssetList.CHARS);
        assetList.addTexture(HATTER_MENU);
        assetList.addTexture(GOMB_Z);
        assetList.addTexture(GOMB_P);
        assetList.addTexture(GOMB_K);


    }


    private OneSpriteStaticActor background;
    private OneSpriteStaticActor gombZ;
    private OneSpriteStaticActor gombP;
    private OneSpriteStaticActor gombK;

    private MyLabel Cim;
    private MyLabel Start;
    private MyLabel Infok;
    private MyLabel Kilepes;



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

        //Labelek

        Cim = new MyLabel(game,"Notes",new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc), Color.BLACK)) {
            @Override
            public void init() {

            }
        };

        Start = new MyLabel(game,"Start",new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.WHITE)) {
            @Override
            public void init() {
                this.setTouchable(null);
            }
        };

        Infok = new MyLabel(game,"Infók",new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.WHITE)) {
            @Override
            public void init() {
                this.setTouchable(null);
            }
        };

        Kilepes = new MyLabel(game,"Kilépés",new Label.LabelStyle(game.getMyAssetManager().getFont(trebuc2), Color.WHITE)) {
            @Override
            public void init() {
                this.setTouchable(null);
            }
        };




    }

    void addListeners(){

        gombZ.addListener(new ClickListener(){

            public void clicked(InputEvent event,float x, float y){
                super.clicked(event,x,y);
                game.setScreenWithPreloadAssets(GameScreen.class, new MyPreLoadingStage(game));
            }
        });

        gombK.addListener(new ClickListener(){

            public void clicked(InputEvent event,float x, float y){
                super.clicked(event,x,y);
                game.setScreenWithPreloadAssets(InfoScreen.class, new MyPreLoadingStage(game));
            }
        });


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
        gombZ.setPosition(210,750);

        gombP.setSize(gombP.getWidth()/2,gombP.getHeight()/2);
        gombP.setPosition(210,200);

        gombK.setSize(gombK.getWidth()/2,gombK.getHeight()/2);
        gombK.setPosition(210,475);

        //Labels

        Cim.setPosition(300,1000);

        Start.setPosition(300,800);
        Start.setFontScale(1.7f);

        Infok.setPosition(300,525);
        Infok.setFontScale(1.7f);

        Kilepes.setPosition(270,250);
        Kilepes.setFontScale(1.7f);



    }

    void addActors() {
        addActor(background);
        addActor(gombZ);
        addActor(gombP);
        addActor(gombK);
        addActor(Cim);
        addActor(Start);
        addActor(Infok);
        addActor(Kilepes);

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
        Cim.setColor(1,1,1,alpha);
        Start.setColor(1,1,1,alpha);
        Infok.setColor(1,1,1,alpha);
        Kilepes.setColor(1,1,1,alpha);



    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fadeIn();//ÁTTŰNÉSSEL JÖNNEK BE A CUCCOK
    }
}
