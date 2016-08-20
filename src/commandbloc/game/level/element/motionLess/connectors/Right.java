package commandbloc.game.level.element.motionLess.connectors;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Connector;

public class Right extends Connector {

	public Right(int x, int y) {
		super(new Sprite("Bloc/RightR.png", "Bloc/RightG.png"), Permeability.BLOCKING, 55, x, y);
	}
}
