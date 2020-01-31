package hu.cehessteg.donto;

import hu.cehessteg.donto.Screen.GameScreen;
import hu.cehessteg.donto.Screen.IntroScreen;
import hu.cehessteg.donto.Screen.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class DontoGame extends MyGame {
	public DontoGame(boolean debug) {
		super(debug);
	}

	@Override
	public void create() {
		super.create();
		setScreen(new MenuScreen(this), false);
	}
}
