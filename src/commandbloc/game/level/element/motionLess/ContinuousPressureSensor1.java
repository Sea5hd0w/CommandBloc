package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class ContinuousPressureSensor1 extends Sensor {

	public ContinuousPressureSensor1(int x, int y) {
		super(new Sprite("Bloc/ContinuousPressureSensor1R.png", "Bloc/ContinuousPressureSensor1G.png"), Permeability.BLOCKING, 5, x, y);
	}
}
