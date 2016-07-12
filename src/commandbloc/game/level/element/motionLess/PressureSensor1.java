package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class PressureSensor1 extends Sensor {

	public PressureSensor1() {
		super(new Sprite("Bloc/PressureSensor1R.png", "Bloc/PressureSensor1G.png"), Permeability.BLOCKING, 4);
	}
}
