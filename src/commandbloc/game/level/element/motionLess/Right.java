package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Right extends Connector {

	public Right() {
		super(new Sprite("Bloc/RightR.png", "Bloc/RightG.png"), Permeability.BLOCKING, 55);
	}
}
