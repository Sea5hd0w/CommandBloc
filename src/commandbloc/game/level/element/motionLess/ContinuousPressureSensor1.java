package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class ContinuousPressureSensor1 extends Sensor {

	public ContinuousPressureSensor1() {
		super(new Sprite("Bloc/ContinuousPressureSensor1R.png", "Bloc/ContinuousPressureSensor1G.png"), Permeability.BLOCKING, 5);
	}
}
