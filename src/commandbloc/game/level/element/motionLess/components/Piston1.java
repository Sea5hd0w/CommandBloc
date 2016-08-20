package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.mobile.Mobile;
import commandbloc.game.level.element.motionLess.Piston;

public class Piston1  extends Piston {

	public Piston1(int x, int y) {
		super(new Sprite("Bloc/Piston1R.png", "Bloc/Piston1G.png"), Permeability.BLOCKING, 7, x, y);
	}

}
