package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;
import commandbloc.game.level.element.motionLess.Piston;

public class Piston2 extends Piston {

	public Piston2(int x, int y) {
		super(new Sprite("Bloc/Piston2R.png", "Bloc/Piston2G.png"), Permeability.BLOCKING, 8, x, y);
	}

}