package commandbloc.game.level.element.motionLess.connectors;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Connector;

public class Up extends Connector {

	public Up(int x, int y) {
		super(new Sprite("Bloc/UpR.png", "Bloc/UpG.png"), Permeability.BLOCKING, 54, x, y);
	}
}
