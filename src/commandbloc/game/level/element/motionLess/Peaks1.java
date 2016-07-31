package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Peaks1 extends Actuator {

	public Peaks1(int x, int y) {
		super(new Sprite("Bloc/Peaks1R.png", "Bloc/Peaks1G.png"), Permeability.BLOCKING, 6, x, y);
	}
}
