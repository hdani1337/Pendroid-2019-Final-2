package hu.cehessteg.donto.Actor;

import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Explosion extends OneSpriteAnimatedActor {

    public static final String EXPLOSION_TEXTURE = "atlas/explosion.atlas";

    public static AssetList assetList;
    static {
        assetList = new AssetList();
        assetList.addTextureAtlas(EXPLOSION_TEXTURE);
    }

    public Explosion(MyGame game, OneSpriteStaticActor bomba) {
        super(game, EXPLOSION_TEXTURE);
        setSize(getWidth()*4, getHeight()*4);
        setPosition(bomba.getX()+(float)Math.random()*bomba.getWidth()-this.getWidth()/2, bomba.getX()+(float)Math.random()*bomba.getHeight()-this.getHeight()/2);
        setFps(60);
        setLooping(false);
    }

    @Override
    public void stop() {
        super.stop();
        this.remove();
    }
}
