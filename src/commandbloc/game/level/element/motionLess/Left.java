package commandbloc.game.level.element.motionLess;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;

public class Left extends Connector {

	public Left(int x, int y) {
		super(new Sprite("Bloc/LeftR.png", "Bloc/LeftG.png"), Permeability.BLOCKING, 57, x, y);
	}
}
