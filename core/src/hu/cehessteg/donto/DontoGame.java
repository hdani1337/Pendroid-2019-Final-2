package hu.cehessteg.donto;

import com.badlogic.gdx.Game;

import hu.cehessteg.donto.Screen.BombScreen;
import hu.cehessteg.donto.Screen.GameScreen;
import hu.cehessteg.donto.Screen.IntroScreen;
import hu.cehessteg.donto.Screen.MenuScreen;
import hu.cehessteg.donto.Screen.RamsayScreen;
import hu.cehessteg.donto.Stage.GameStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class DontoGame extends MyGame {
	public DontoGame(boolean debug) {
		super(debug);
	}

	@Override
	public void create() {
		super.create();
		setScreen(new IntroScreen(this), true);
		GameStage.currentID = 1;
	}
}
