package hu.cehessteg.donto.Screen;

import hu.cehessteg.donto.Stage.BombStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BombScreen extends MyScreen {
    public BombScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(BombStage.class, assetList);
    }


    @Override
    protected void afterAssetsLoaded() {
        addStage(new BombStage(game),1,true);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }

    @Override
    public void init() {

    }
}
