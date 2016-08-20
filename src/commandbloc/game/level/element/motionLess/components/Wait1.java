package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Wait;
import commandbloc.game.view.LevelFrame;

public class Wait1 extends Wait implements Runnable {

	public Wait1(int x, int y) {
		super(new Sprite("Bloc/Wait1R.png", "Bloc/Wait1G.png"), x, y, 5);
	}

}