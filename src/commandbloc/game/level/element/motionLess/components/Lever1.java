package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Lever;
import commandbloc.game.level.element.motionLess.Orientation;

public class Lever1 extends Lever {

	public Lever1(int x, int y) {
		super(new Sprite("Bloc/Lever1R.png", "Bloc/Lever1G.png"), Permeability.BLOCKING, 3, x, y);
		this.setOrientation(Orientation.LEFT);
	}

}
