package commandbloc.game.level.element.motionLess.connectors;

import commandbloc.game.level.element.Permeability;
import commandbloc.game.level.element.Sprite;
import commandbloc.game.level.element.motionLess.Connector;

public class Cross extends Connector {

	public Cross(int x, int y) {
		super(new Sprite("Bloc/CrossR.png", "Bloc/CrossG.png"), Permeability.BLOCKING, 49, x, y);
	}
}
