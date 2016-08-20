package commandbloc.game.level.element.motionLess.connectors;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Connector;

public class DownLeft extends Connector {

	public DownLeft(int x, int y) {
		super(new Sprite("Bloc/DownLeftR.png", "Bloc/DownLeftG.png"), Permeability.BLOCKING, 52, x, y);
	}
}
