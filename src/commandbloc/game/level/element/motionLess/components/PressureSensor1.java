package commandbloc.game.level.element.motionLess.components;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.PressureSensor;

public class PressureSensor1 extends PressureSensor {

	public PressureSensor1(int x, int y) {
		super(new Sprite("Bloc/PressureSensor1R.png", "Bloc/PressureSensor1G.png"), Permeability.BLOCKING, 4, x, y);
	}
}
