package hu.cehessteg.donto.Screen;

import hu.cehessteg.donto.Stage.BombStage;
import hu.cehessteg.donto.Stage.GameOverStage;
import hu.cehessteg.donto.Stage.RamsayStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class RamsayScreen extends MyScreen {
    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(RamsayStage.class, assetList);
        assetList.collectAssetDescriptor(GameOverStage.class, assetList);
    }
    public RamsayScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new RamsayStage(game),1,true);
        addStage(new GameOverStage(game),2,true);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }

    @Override
    public void init() {

    }
}
