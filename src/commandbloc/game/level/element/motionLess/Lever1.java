package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Lever1 extends Sensor {

	public Lever1(int x, int y) {
		super(new Sprite("Bloc/Lever1R.png", "Bloc/Lever1G.png"), Permeability.BLOCKING, 3, x, y);
		this.setOrientation(Orientation.LEFT);
	}

}
