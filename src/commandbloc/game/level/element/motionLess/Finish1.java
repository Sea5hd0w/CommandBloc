package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Finish1 extends Sensor {

	public Finish1() {
		super(new Sprite("Bloc/Finish1R.png", "Bloc/Finish1G.png"), Permeability.BLOCKING, 2);
	}

}
