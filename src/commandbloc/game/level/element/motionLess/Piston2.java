package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Piston2 extends Actuator {

	public Piston2() {
		super(new Sprite("Bloc/Piston2R.png", "Bloc/Piston2G.png"), Permeability.BLOCKING, 8);
	}
}
