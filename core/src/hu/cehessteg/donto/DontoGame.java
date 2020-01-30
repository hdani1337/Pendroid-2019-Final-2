package hu.cehessteg.donto;

import hu.cehessteg.donto.Screen.IntroScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class DontoGame extends MyGame {
	@Override
	public void create() {
		super.create();
		setScreen(new IntroScreen(this), false);
	}
}
