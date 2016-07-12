package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class TNT1 extends Actuator {

	public TNT1() {
		super(new Sprite("Bloc/TNT1.png", "Bloc/BlocT.png"), Permeability.BLOCKING, 9);
	}
}
