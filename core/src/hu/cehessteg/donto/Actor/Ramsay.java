package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Ramsay extends OneSpriteStaticActor {

    public static final String RAMSAY_1 = "ramsay/ramsay1.png";
    public static final String RAMSAY_2 = "ramsay/ramsay2.png";
    public static final String RAMSAY_3 = "ramsay/ramsay3.png";
    public static final String RAMSAY_4 = "ramsay/ramsay4.png";
    public static final String RAMSAY_5 = "ramsay/ramsay5.png";

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.addTexture(RAMSAY_1);
        assetList.addTexture(RAMSAY_2);
        assetList.addTexture(RAMSAY_3);
        assetList.addTexture(RAMSAY_4);
        assetList.addTexture(RAMSAY_5);
    }

    byte rage = 0;

    public Ramsay(MyGame game) {
        super(game, RAMSAY_1);
        addListeners();
    }

    private void addListeners(){
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                rage++;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(rage >= 40) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_5))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_5));
        }
        if(rage >= 30) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_4))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_4));
        }
        else if (rage >= 20) {
                if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_3))
                    sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_3));
            }
        else if (rage >= 10) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_2))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_2));
        }
        else if (rage >= 0) {
            if (getTexture() != game.getMyAssetManager().getTexture(RAMSAY_1))
                sprite.setTexture(game.getMyAssetManager().getTexture(RAMSAY_1));
        }
    }
}
