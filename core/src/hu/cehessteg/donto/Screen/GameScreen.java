package hu.cehessteg.donto.Screen;

import hu.cehessteg.donto.Stage.GameOverStage;
import hu.cehessteg.donto.Stage.GameStage;
import hu.cehessteg.donto.Stage.HudStage;
import hu.cehessteg.donto.Stage.PauseStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {
    public GameScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(GameStage.class, assetList);
        AssetList.collectAssetDescriptor(HudStage.class, assetList);
        AssetList.collectAssetDescriptor(PauseStage.class, assetList);
        AssetList.collectAssetDescriptor(GameOverStage.class,assetList);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new GameStage(game),1,false);
        addStage(new HudStage(game),2,true);
        addStage(new PauseStage(game),3,true);
        addStage(new GameOverStage(game),4,true);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }

    @Override
    public void init() {

    }
}
