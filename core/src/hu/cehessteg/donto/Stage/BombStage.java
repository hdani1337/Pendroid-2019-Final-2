package hu.cehessteg.donto.Stage;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class BombStage extends MyStage {
    public BombStage(MyGame game) {
        super(new ResponseViewport(800), game);
    }
}
