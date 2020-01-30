package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class HudStage extends MyStage {

    public static final String PAUSE_TEXTURE = "menu/pause.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(PAUSE_TEXTURE);
    }

    OneSpriteStaticActor pause;

    public HudStage(MyGame game) {
        super(new ResponseViewport(900), game);
        assignment();
        setSizesAndPositions();
        addListeners();
        addActors();
    }

    private void assignment()
    {
        pause = new OneSpriteStaticActor(game,PAUSE_TEXTURE);
    }

    private void addListeners()
    {
        pause.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                GameStage.isAct = false;
            }
        });
    }

    private void setSizesAndPositions()
    {
        pause.setPosition(getViewport().getWorldWidth()-pause.getWidth(), getViewport().getWorldHeight()-pause.getHeight());
    }

    private void addActors()
    {
        addActor(pause);
    }
}
