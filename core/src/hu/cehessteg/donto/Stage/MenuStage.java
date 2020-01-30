package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    public static String trebuc = "other/trebuc.ttf";
    public static AssetList assetList = new AssetList();
    public static final String EXIT = "menu/exit.png";
    public static final String OPTIONS_TEXTURE = "menu/options.png";
    static {
        assetList.addFont(trebuc, trebuc, 120, Color.WHITE, AssetList.CHARS);
        assetList.addTexture(EXIT);
        assetList.addTexture(OPTIONS_TEXTURE);
    }

    private OneSpriteStaticActor exitRing;
    private OneSpriteStaticActor options;


    public MenuStage(final MyGame game) {
        super(new ResponseViewport(900), game);
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
        //BEÁLLÍTÁSOK GOMB
        options = new OneSpriteStaticActor(game,OPTIONS_TEXTURE);

        //KILÉPÉS GOMB
        exitRing = new OneSpriteStaticActor(game,EXIT){
        };

    }

    void addListeners(){
        //KILÉPÉS LISTENER
        exitRing.addListener(new ClickListener(){

            public void clicked(InputEvent event,float x, float y){
                super.clicked(event,x,y);
                Gdx.app.exit();
            }
        });
    }


    void setPositions(){

        //EXIT GOMB
        exitRing.setPosition(0,0);

        //BEÁLLÍTÁSOK GOMB
        options.setPosition(300,0);
    }

    void addActors() {
        addActor(exitRing);
        addActor(options);
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
        exitRing.setAlpha(alpha);
        options.setAlpha(alpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        fadeIn();//ÁTTŰNÉSSEL JÖNNEK BE A CUCCOK
    }
}
