package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Piston1  extends Actuator {

	public Piston1() {
		super(new Sprite("Bloc/Piston1R.png", "Bloc/Piston1G.png"), Permeability.BLOCKING, 7);
	}
}
